package com.cono.dogrami.member.controller;

import com.cono.dogrami.careboard.model.vo.CareBoard;
import com.cono.dogrami.common.FileNameChange;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.daily.model.vo.Daily;
import com.cono.dogrami.diary.model.vo.Diary;
import com.cono.dogrami.member.model.service.MemberService;
import com.cono.dogrami.member.model.vo.Member;
import com.cono.dogrami.placeboard.model.vo.PlaceBoard;
import com.cono.dogrami.question.model.vo.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {
    // 이 컨트롤로 안의 메소드들이 구동되었는지 확인하는 로그를
    // 출력하기 위한 로그 객체를 생성
    private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired // 자동 의존성주입(DI) : 자동 객체 생성됨
    private MemberService memberService;

    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private JavaMailSender mailSender;

    // 로그인 페이지 내보내기용 메소드
    @RequestMapping(value = "loginPage.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String moveLoginPage() {
        return "member/loginPage";
    }

    // 회원가입 페이지 내보내기용
    @RequestMapping("enrollPage.do")
    public String moveEnrollPage() {
        return "member/enrollPage";
    }

    // 마이페이지 내보내기용
    @RequestMapping("myinfoPage.do")
    public String moveMyinfoPage() {
        return "member/myinfoPage";
    }

    // 내가쓴글 목록 페이지
    @RequestMapping("myboardListPage.do")
    public String movemyboardListPage(@RequestParam(value = "boardType", required = false) String boardType, Model model, HttpSession session) {
        String user_id = ((Member) session.getAttribute("loginMember")).getUser_id();

        ArrayList<Daily> dailyList = null;
        ArrayList<Diary> diaryList = null;
        ArrayList<CareBoard> careList = null;
        ArrayList<PlaceBoard> placeList = null;
        ArrayList<Question> questionList = null;

        if (boardType == null || boardType.equals("daily")) {
            dailyList = memberService.selectMyDailyBoardList(user_id);
            model.addAttribute("boardList", dailyList);
        } else if (boardType.equals("diary")) {
            diaryList = memberService.selectMyDiaryBoardList(user_id);
            model.addAttribute("boardList", diaryList);
        } else if (boardType.equals("care")) {
            careList = memberService.selectMyCareBoardList(user_id);
            model.addAttribute("boardList", careList);
        } else if (boardType.equals("place")) {
            placeList = memberService.selectMyPlaceBoardList(user_id);
            model.addAttribute("boardList", placeList);
        } else if (boardType.equals("question")) {
            questionList = memberService.selectMyQuestionBoardList(user_id);
            model.addAttribute("boardList", questionList);
        }

        return "member/myboardListPage";
    }

    // ajax 통신으로 아이디 중복확인 요청 처리용 메소드
    @RequestMapping(value = "idchk.do", method = RequestMethod.POST)
    public void dupCheckIdMethod(@RequestParam("userid") String userid, HttpServletResponse response) throws IOException {
        int idCount = memberService.selectDupCheckId(userid);

        String returnStr = null;
        if (idCount == 0) {
            returnStr = "ok";
        } else {
            returnStr = "duple";
        }

        // response 를 이용해서 클라이언트와 출력스트림을 연결하고 값 보냄
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.append(returnStr);
        out.flush();
        out.close();
    }

    // 회원가입 요청 처리용 메소드
    @RequestMapping(value = "enroll.do", method = RequestMethod.POST)
    public String memberInsertMethod(Member member, Model model, HttpServletRequest request, @RequestParam(name = "upfile", required = false) MultipartFile profilePicture) {

        String savePath = request.getSession().getServletContext().getRealPath("resources/user_upfiles");

        logger.info("enroll.do : " + member);
        // 패스워드 암호화 처리
        member.setUser_pwd(bcryptPasswordEncoder.encode(member.getUser_pwd()));

        logger.info("after encode: " + member.getUser_pwd());
        logger.info("length: " + member.getUser_pwd().length());

        if (!profilePicture.isEmpty()) {

            //전송온 파일이름 추출함
            String fileName = profilePicture.getOriginalFilename();

            //다른 공지글의 첨부파일과 파일명이 중복되어서 덮어쓰기 되는것을 막기 위해, 파일명을 변경해서  폴더에 저장하는 방식을 사용할 수 있음
            //변경 파일명 : 년월일시분초.확장자
            if (fileName != null && fileName.length() > 0) {
                //바꿀 파일명에 대한 문자열 만들기

                String renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");
                logger.info("첨부 파일명 확인 : " + fileName + ", " + renameFileName);

                //파일 객체 만들기
                File renameFile = new File(savePath + "\\" + renameFileName);

                //폴더에 저장 처리
                try {
                    profilePicture.transferTo(renameFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("message", "첨부파일 저장 실패!");
                    return "common/error";
                }

                //객체에 첨부파일 정보 기록 저장
                member.setUser_picture(fileName);
                member.setUser_picture_rename(renameFileName);
            }
        }

        if (memberService.insertMember(member) > 0) {
            // 회원 가입 성공
            return "member/loginPage";
        } else {
            // 회원 가입 실패
            model.addAttribute("message", "회원 가입 실패!");
            return "common/error";
        }
    }


    // 로그인 패스워드 비교
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public String loginMethod(Member member, HttpSession session, SessionStatus status, Model model) {
        logger.info("login.do : " + member);
        // 암호화된 패스워드와 전송온 글자타입 패스워드를 비교함.
        // matches(글자타입 패스워드, 암호화된 패스워드)
        Member loginMember = memberService.selectMember(member.getUser_id());
        if (loginMember != null && this.bcryptPasswordEncoder.matches(member.getUser_pwd(), loginMember.getUser_pwd())) {
            session.setAttribute("loginMember", loginMember);
            status.setComplete(); // 로그인 요청 성공, 200 전송함
            return "common/main";
        } else {
            model.addAttribute("message", "로그인 실패 : 아이디나 암호 확인하세요.<br>" + "또는 로그인 제한된 회원인지 관리자에게 문의하세요.");
            return "common/error";
        }
    }

    // 회원 탈퇴(삭제) 요청 처리용
    @RequestMapping(value = "mdel.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String memberDeleteMethod(@RequestParam("user_id") String user_id, Model model) {
        logger.info("mdel.do : " + user_id);

        if (memberService.deleteMember(user_id) > 0) {
            // 회원 탈퇴 성공시, 자동 로그아웃 처리해야 함
            // 컨트롤러 메소드에서 다른 [컨트롤러] 메소드 호출할 수 있음
            return "redirect:logout.do";
        } else {
            model.addAttribute("message", user_id + " : 회원 삭제 실패!");
            return "common/error";
        }
    }

    // 로그아웃
    @RequestMapping("logout.do")
    public String logoutMethod(HttpServletRequest request, Model model) {

        HttpSession session = request.getSession(false);
        logger.info("logout.do : " + session);

        if (session != null) {
            session.invalidate();
            return "common/main";
        } else {
            model.addAttribute("message", "로그인 세션이 존재하지 않습니다");
            return "common/error";
        }
    }

    // 회원정보 수정페이지 내보내기용
    @RequestMapping("moveup.do")
    public String moveUpdatePage(@RequestParam("user_id") String user_id, Model model) {
        Member member = memberService.selectMember(user_id);

        if (member != null) {
            model.addAttribute("member", member);
            return "member/updatePage";
        } else {
            model.addAttribute("message", user_id + " : 회원 조회 실패!");
            return "common/error";
        }
    }

    // 회원정보 수정 처리용 : 수정 성공시 myinfoPage.jsp 로 이동함
    @RequestMapping(value = "mupdate.do", method = RequestMethod.POST)
    public String memberUpdateMethod(Member member, Model model, @RequestParam("origin_user_pwd") String originUser_pwd) {

        logger.info("mupdate.do : " + member);

        // 새로운 암호가 전송이 왔다면, 패스워드 암호화 처리함
        String user_pwd = member.getUser_pwd().trim();
        if (user_pwd != null && user_pwd.length() > 0) {
            // 암호화된 기존의 패스워드와 새로운 패스워드를
            // 비교해서 다른 값이면
            if (!this.bcryptPasswordEncoder.matches(user_pwd, originUser_pwd)) {
                // member 에 새로운 패스워드를 암호화해서 기록함
                member.setUser_pwd(this.bcryptPasswordEncoder.encode(user_pwd));
            }
        } else {
            // 새로운 패스워드 값이 없다면, member 에 원래 패스워드 기록
            member.setUser_pwd(originUser_pwd);
        }

        if (memberService.updateMember(member) > 0) {
            // 수정이 성공했다면, 컨트롤러의 메소드를 직접 호출함
            // 필요시, 값을 전달할 수도 있음 : 쿼리스트링 사용함
            // ?이름=값&이름=값
            return "redirect:myinfo.do?user_id=" + member.getUser_id();
        } else {
            model.addAttribute("message", member.getUser_id() + " : 회원 정보 수정 실패!");
            return "common/error";
        }
    }

    // 마이페이지 클릭시 내 정보 보기 요청 처리용 메소드
    // 리턴 타입은 String, ModelAndView 를 사용할 수 있음
    @RequestMapping("myinfo.do")
    public ModelAndView memberDetailMethod(@RequestParam("user_id") String user_id, ModelAndView mv) {
        // 서비스로 아이디 전달하고, 해당 회원정보 받기
        Member member = memberService.selectMember(user_id);

        if (member != null) {
            mv.addObject("member", member);
            // Model 또는 ModelAndView 에 저장하는 것은
            // request.setAttribute("member", member); 과 같음
            mv.setViewName("member/myinfoPage");
        } else {
            mv.addObject("message", user_id + " : 회원 정보 조회 실패!");
            mv.setViewName("common/error");
        }

        return mv;
    }

    // 회원관리용 회원전체목록 조회 처리용
    @RequestMapping("mlist2.do")
    public ModelAndView memberListViewMethod(@RequestParam(name = "page", required = false) String page,
                                             HttpServletRequest request, ModelAndView mv) {
        HttpSession session = request.getSession();
        Member loginMember = (Member) session.getAttribute("loginMember");

        // 관리자인지 확인
        if (loginMember != null && "Y".equals(loginMember.getUser_admin())) {
            int currentPage = 1;
            if (page != null) {
                currentPage = Integer.parseInt(page);
            }
            int limit = 20;
            int listCount = memberService.selectListCount();
            String url = "mlist2.do";
            Paging paging = new Paging(listCount, currentPage, limit, url);
            paging.calculator();

            ArrayList<Member> list = memberService.selectList(paging);

            if (list != null && list.size() > 0) {
                mv.addObject("list", list);
                mv.addObject("paging", paging);

                // model.addAttribute("nickname",nickname);
                mv.setViewName("member/memberListView");
            } else {
                mv.addObject("message", currentPage + " 페이지 목록 조회 실패!");
                mv.setViewName("common/error");
            }
        } else {
            mv.addObject("message", "접근 권한이 없습니다.");
            mv.setViewName("common/error");
        }
        return mv;

    }

    // 관리자 기능 : 회원 로그인 제한/가능 처리용 메소드
    @RequestMapping("login_limit.do")
    public String changeLoginLimitMethod(Member member, Model model) {
        logger.info("login_limit.do : " + member.getUser_id() + ", " + member.getLogin_limit());
        if (memberService.updateLoginLimit(member) > 0) {
            return "redirect:mlist2.do";
        } else {
            model.addAttribute("message", "로그인 제한/허용 처리 오류 발생!");
            return "common/error";
        }
    }

    // 관리자 권한 부여 처리용 메소드
    @RequestMapping("user_admin.do")
    public String changeUserAdminMethod(Member member, Model model) {
        logger.info("user_admin.do : " + member.getUser_id() + ", " + member.getUser_admin());
        if (memberService.updateUserAdmin(member) > 0) {
            return "redirect:mlist2.do";
        } else {
            model.addAttribute("message", "관리자 권한 부여 처리 오류 발생!");
            return "common/error";
        }
    }

    // 회원 검색 처리용
    @RequestMapping(value = "msearch2.do", method = { RequestMethod.GET, RequestMethod.POST })
    public ModelAndView memberSearchMethod(@RequestParam("action") String action,
                                           @RequestParam(name = "page", required = false) String page, HttpServletRequest request, ModelAndView mv) {
//		String action =request.getParameter("action");
        String keyword = null;

        keyword = request.getParameter("keyword");

        ArrayList<Member> list = null;
        int currentPage = 1;
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }
        int limit = 20;
        int listCount = 0;
        String url = "msearch2.do";
        Paging paging = new Paging(listCount, currentPage, limit, url);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("action", action);
        params.put("keyword", keyword);
        listCount = memberService.selectListCountSearch(params);
        paging.setListCount(listCount);

        paging.calculator();
        params.put("paging", paging);
        list = memberService.selectSearch(params);

        if (list != null && list.size() > 0) {
            // model.addAttribute("list", list);
            mv.addObject("list", list);
            mv.addObject("action", action);
            mv.addObject("keyword", keyword);
            mv.addObject("paging", paging);
            mv.setViewName("member/memberListView");
        } else {
            mv.addObject("message", action + " 검색에 대한 결과가 존재하지 않습니다.");
            mv.setViewName("common/error");
        }

        return mv;
    }

    @RequestMapping(value = "findpwform.do")
    public String find_pw_form() throws Exception {
        return "member/findpw";
    }

    // 이메일 인증
    public void sendEmail(Member member, String div, String pw) {
        // 보내는 사람 EMail, 제목, 내용
        String fromEmail = "s941204@naver.com";
        String title = "";
        String msg = "";

        if (div.equals("findpw")) {
            title = "도그라미 임시 비밀번호 입니다.";
            msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
            msg += "<h3 style='color: blue;'>";
            msg += member.getUser_id() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
            msg += "<p>임시 비밀번호 : ";
            msg += pw + "</p></div>";
        }

        // 받는 사람 E-Mail 주소
        String email = member.getEmail();
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(fromEmail);
            helper.setTo(email);
            helper.setSubject(title);
            helper.setText(msg, true);
            mailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "findpw.do", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public void findpw(HttpServletResponse response, @RequestParam(value = "user_id", required = false) String user_id, Member member) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Member ck = memberService.selectMember(user_id);
        PrintWriter out = response.getWriter();
        //가입된 아이디가 없으면
        if (ck == null) {
            out.print("등록되지 않은 아이디입니다.");
            out.close();
        }

        //가입된 이메일이 아니면
        else if (!member.getEmail().equals(ck.getEmail())) {
            out.print("등록되지 않은 이메일입니다.");
            out.close();
        } else {
            //임시 비밀번호 생성
            String pw = "";
            for (int i = 0; i < 12; i++) {
                pw += (char) ((Math.random() * 26) + 97);
            }
            member.setUser_pwd(bcryptPasswordEncoder.encode(pw));
            memberService.updatepw(member);
            sendEmail(member, "findpw", pw);

            out.print("이메일로 임시 비밀번호를 발송하였습니다.");
            out.close();
        }
    }
}
