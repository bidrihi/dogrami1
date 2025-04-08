package com.cono.dogrami.daily.controller;

import com.cono.dogrami.common.FileNameChange;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.daily.model.service.DailyService;
import com.cono.dogrami.daily.model.vo.Daily;
import com.cono.dogrami.dailyreply.model.service.DailyReplyService;
import com.cono.dogrami.dailyreply.model.vo.DailyReply;
import com.cono.dogrami.member.model.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DailyController {
    private static final Logger logger = LoggerFactory.getLogger(DailyController.class);

    @Autowired
    private DailyService dailyService;

    @Autowired
    private DailyReplyService dailyReplyService;


//	게시글 전체 목록보기 (페이징 처리전)
//	@RequestMapping("dailylist.do")
//	public String dailyListMethod(Model model) {
//		
//		ArrayList<Daily> list = dailyService.selectList();
//		
//		for(int i = 0; i <list.size(); i++ ) {
//			list.get(i).setBoard_writer(dailyService.selectnickname(list.get(i).getBoard_no()));
//		}
//		
//		if(list != null && list.size() > 0) {
//			
//			model.addAttribute("list",list);
//			return "daily/dailyListView" ;
//		}else {
//			return "daily/dailyListView";
//		}
//	}

    //게시글 전체 목록보기 (페이징처리 후)
    @RequestMapping("dailylist.do")
    public ModelAndView dailyListMethod(@RequestParam(name = "page", required = false) String page, ModelAndView mv) {

        int currentPage = 1;
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }

        // 한 페이지에 게시글 10개씩 출력되게 하는 경우 :
        // 페이징 계산 처리 - 별도의 클래스로 작성해서 이용해도 됨
        int limit = 10; // 한 페이지에 출력할 목록 갯수
        // 총 페이지 수 계산을 위해 게시글 총 갯수 조회해 옴
        int listCount = dailyService.selectListCount();
        String url = "dailylist.do";
        Paging paging = new Paging(listCount, currentPage, limit, url);
        paging.calculator();
        logger.info("page : " + page);

        ArrayList<Daily> list = dailyService.selectList(paging);

        //댓글 갯수 list
        ArrayList<Integer> replycount = new ArrayList<Integer>();

        //닉네임 list
        //ArrayList<String> nicklist = new ArrayList<String>();
        // 닉네임 select후 작성자로 덮어쓰기
        //for(int i = 0; i <list.size(); i++ ) {
		//	list.get(i).setBoard_writer(dailyService.selectnickname(list.get(i).getBoard_no()));
        //}
        for (int i = 0; i < list.size(); i++) {
            //댓글 갯수
            //replycount.add(dailyReplyService.selectDailyReplyCount(list.get(i).getBoard_no()));
            int count = dailyReplyService.selectDailyReplyCount(list.get(i).getBoard_no());
            replycount.add(count);

            // 닉네임 처리
            //list.get(i).setBoard_writer(dailyService.selectnickname(list.get(i).getBoard_no()));
            //String nickname = dailyService.selectnickname(list.get(i).getBoard_no());
            //nicklist.add(nickname);
        }

        if (list != null && list.size() > 0) {
            mv.addObject("list", list);
            mv.addObject("paging", paging);
            mv.addObject("replycount", replycount);
            //mv.addObject("nicklist",nicklist);
            mv.setViewName("daily/dailyListView");
        } else {
            mv.setViewName("daily/dailyListView");
        }
        return mv;
    }

    //게시글 상세보기
    @RequestMapping("dailydetail.do")
    public ModelAndView dailyDetailMethod(
            ModelAndView mv, @RequestParam("board_no") int board_no,
            @RequestParam(name = "page", required = false) String page,
            HttpServletRequest request) {

        //페이징
        int currentPage = 1;
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }

        //조회수 1증가 처리 (조회숫자만 증가하면 되기때문에 반환값 안 받음)
        dailyService.updateDailyBoardReadcount(board_no);

        //해당 게시글 조회
        Daily daily = dailyService.selectDailyBoard(board_no);

        //게시글 작성자의 닉네임 가져오기
        //String nickname = dailyService.selectnickname(board_no);

        //댓글 리스트 불러오기
        ArrayList<DailyReply> dailyreply = dailyReplyService.selectList(board_no);

        //댓글 작성자의 닉네임 가져오기
        //for(int i = 0; i < dailyreply.size(); i++) {
		//	dailyreply.get(i).setRef_writer(dailyReplyService.selectnickname(dailyreply.get(i).getRef_no()));
        //}

        //댓글 갯수
        int replycount = dailyReplyService.selectDailyReplyCount(board_no);

        //좋아요 세션  값 가져오기
//	   HttpSession session = request.getSession();
//	   String doILike = ((String) session.getAttribute("doLikeNum_"+board_no)).equals("") ? "N":"Y";
//	   String doILike = "";
//	   
//		if( session.getAttribute("doLikeNum_"+board_no) != null ) {
//			doILike = (String) session.getAttribute("doLikeNum_"+board_no); }
//		
//		if(doILike.equals("") || doILike.equals(null)) {
//			doILike = "N";}

        //좋아요 체크
        HttpSession session = request.getSession();
        String likeResult = "N";

        if (session.getAttribute("loginMember") != null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("board_no", board_no);
            params.put("user_id", ((Member) session.getAttribute("loginMember")).getUser_id());

            if (dailyService.selectDailyLikeCheck(params) != null) {
                likeResult = "Y";
            }
        }

        if (daily != null) {
            mv.addObject("daily", daily);
            //mv.addObject("nickname",nickname);
            mv.addObject("dailyreply", dailyreply);
            mv.addObject("replycount", replycount);
            mv.addObject("currentPage", currentPage);
            //mv.addObject("doILike",doILike);
            mv.addObject("likeResult", likeResult);
            mv.setViewName("daily/dailyDetailView");
        } else {
            mv.addObject("message", board_no + "번 게시글 조회 실패!");
            mv.setViewName("common/error");
        }
        return mv;
    }

    //게시글 작성폼으로 이동
    @RequestMapping("dailywrite.do")
    public String moveDailyWriteForm() {
        return "daily/dailywriteform";
    }

    //게시글 작성하기
    @RequestMapping(value = "dailyinsert.do", method = RequestMethod.POST)
    public String dailyInsertMethod(Daily daily, Model model, HttpServletRequest request, @RequestParam(name = "upfile", required = false) MultipartFile mfile) {

        //게시글 첨부파일 저장 폴더 경로 지정
        String savePath = request.getSession()
                .getServletContext().getRealPath(
                        "resources/daily_upfiles");

        //첨부파일이 있을때
        if (!mfile.isEmpty()) {

            //전송온 파일이름 추출함
            String fileName = mfile.getOriginalFilename();

            //다른 공지글의 첨부파일과 파일명이 중복되어서
            //덮어쓰기 되는것을 막기 위해, 파일명을 변경해서
            //폴더에 저장하는 방식을 사용할 수 있음
            //변경 파일명 : 년월일시분초.확장자
            if (fileName != null && fileName.length() > 0) {
                //바꿀 파일명에 대한 문자열 만들기

                String renameFileName = FileNameChange.change
                        (fileName, "yyyyMMddHHmmss");


                logger.info("첨부 파일명 확인 : " + fileName
                        + ", " + renameFileName);

                //파일 객체 만들기
                File renameFile = new File(
                        savePath + "\\" + renameFileName);

                //폴더에 저장 처리
                try {
                    mfile.transferTo(renameFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("message",
                            "첨부파일 저장 실패!");
                    return "common/error";
                }

                //board 객체에 첨부파일 정보 기록 저장
                daily.setBoard_old_file(fileName);
                daily.setBoard_new_file(renameFileName);
            } //이름바꾸기
        }  //새로운 첨부파일이 있을 때

        if (dailyService.insertDailyBoard(daily) > 0) {
            model.addAttribute("daily", daily);
            return "redirect:dailylist.do";
        } else {
            model.addAttribute("message", " 등록 실패");
            return "common/error";
        }
    }

    //파일다운로드
    @RequestMapping("dailyfdown.do")
    public ModelAndView dailyfileDownMethod(
            ModelAndView mv, HttpServletRequest request,
            @RequestParam("oldfile") String originalFileName,
            @RequestParam("newfile") String renameFileName) {
        //공지사항 첨부파일 저장폴더에 대한 경로(path) 지정
        String savePath = request.getSession()
                .getServletContext().getRealPath(
                        "resources/daily_upfiles");

        //저장 폴더에서 읽을 파일에 대한 파일 객체 생성함
        File renameFile = new File(savePath + "\\" + renameFileName);
        //파일 다운시 내보낼 원래 이름의 파일 객체 생성함
        File originFile = new File(originalFileName);

        //파일 다운로드 뷰로 전달할 정보 저장
        mv.setViewName("filedown");  //등록된 파일다운로드 뷰의 id명
        mv.addObject("renameFile", renameFile);
        mv.addObject("originFile", originFile);

        return mv;
    }

    //게시글 수정폼으로 이동
    @RequestMapping("dailyupview.do")
    public String moveDailyUpdateView(
            @RequestParam("board_no") int board_no,
            Model model) {

        Daily daily = dailyService.selectDailyBoard(board_no);
        String nickname = dailyService.selectnickname(board_no);

        if (daily != null) {
            model.addAttribute("daily", daily);
            model.addAttribute("nickname", nickname);
            return "daily/dailyUpdateForm";
        } else {
            model.addAttribute("message", board_no + "에 대한 게시글 정보가 없습니다");
            return "common/error";
        }
    }

    //게시글 수정하기
    @RequestMapping(value = "dailyupdate.do", method = RequestMethod.POST)
    public String dailyUpdateMethod(Daily daily, Model model, HttpServletRequest request,
                                    @RequestParam(name = "delfile", required = false) String delFlag,
                                    @RequestParam(name = "upfile", required = false) MultipartFile mfile) {

        //게시원글 첨부파일 저장 폴더 경로 지정
        String savePath =
                request.getSession().getServletContext().getRealPath("resources/daily_upfiles");

        //첨부파일이 수정 처리된 경우 ---------------------------
        //1. 원래 첨부파일이 있는데 '파일삭제'를 선택한 경우
        if (daily.getBoard_old_file() != null && delFlag != null && delFlag.equals("yes")) {
            //저장 폴더에 있는 파일을 삭제함
            new File(savePath + "\\" + daily.getBoard_new_file()).delete();
            //daily 의 파일 정보도 제거함
            daily.setBoard_old_file(null);
            daily.setBoard_new_file(null);
        }

        //2. 게시글 첨부파일은 1개만 가능한 경우
        //새로운 첨부파일이 있을때
        if (!mfile.isEmpty()) {
            //2-1. 이전 첨부파일이 있을 때
            if (daily.getBoard_old_file() != null) {
                //저장 폴더에 있는 이전 파일을 삭제함
                new File(savePath + "\\" + daily.getBoard_new_file()).delete();
                //daily 의 이전 파일 정보도 제거함
                daily.setBoard_old_file(null);
                daily.setBoard_new_file(null);
            }

            //2-2. 이전 첨부파일이 없을 때
            //전송온 파일이름 추출함
            String fileName = mfile.getOriginalFilename();

            //다른 게시글의 첨부파일과 파일명이 중복되어서 덮어쓰기 되는것을 막기 위해, 파일명을 변경해서
            //폴더에 저장하는 방식을 사용할 수 있음
            //변경 파일명 : 년월일시분초.확장자
            if (fileName != null && fileName.length() > 0) {
                String renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");
                logger.info("첨부 파일명 확인 : " + fileName + ", " + renameFileName);
                //폴더에 저장 처리
                try {
                    mfile.transferTo(new File(savePath + "\\" + renameFileName));
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("message", "첨부파일 저장 실패!");
                    return "common/error";
                }

                //daily 객체에 첨부파일 정보 기록 저장
                daily.setBoard_old_file(fileName);
                daily.setBoard_new_file(renameFileName);
            } //이름바꾸기
        }  //새로운 첨부파일이 있을 때

        if (dailyService.updateDailyBoard(daily) > 0) {
            //게시글 수정 성공시 상세보기 페이지로 이동
            model.addAttribute("board_no", daily.getBoard_no());
            return "redirect:dailydetail.do?board_no=" + daily.getBoard_no();
        } else {
            model.addAttribute("message", daily.getBoard_no() + "번 게시글 수정 실패");
            return "common/error";
        }
    }

    //게시글 검색하기
    @RequestMapping(value = "dailysearch.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView dailySearchMethod(
            @RequestParam("action") String action,
            @RequestParam(name = "page", required = false) String page,
            @RequestParam("keyword") String keyword,
            ModelAndView mv) {

        ArrayList<Daily> list = null;
        int currentPage = 1;
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }
        int limit = 10;
        int listCount = 0;
        String url = "dailysearch.do";
        Paging paging = new Paging(listCount, currentPage, limit, url);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("action", action);
        params.put("keyword", keyword);
        listCount = dailyService.selectListCountSearch(params);
        paging.setListCount(listCount);

        paging.calculator();
        params.put("paging", paging);
        list = dailyService.selectSearch(params);

        //댓글 갯수 list
        ArrayList<Integer> replycount = new ArrayList<Integer>();

        for (int i = 0; i < list.size(); i++) {

            int count = dailyReplyService.selectDailyReplyCount(list.get(i).getBoard_no());
            replycount.add(count);

        }

        if (list != null && list.size() > 0) {
            mv.addObject("list", list);
            mv.addObject("action", action);
            mv.addObject("keyword", keyword);
            mv.addObject("paging", paging);
            mv.addObject("replycount", replycount);
            mv.setViewName("daily/dailyListView");
        } else {
            mv.setViewName("redirect:dailylist.do");
        }

        return mv;

    }

    //게시글 삭제 (댓글은 오라클 cascade제약조건으로 같이 삭제됨)
    @RequestMapping("dailydelete.do")
    public String dailyDeleteMethod(
            @RequestParam("board_no") int board_no,
            @RequestParam(name = "board_new_file", required = false) String renameFileName,
            HttpServletRequest request, Model model) {

        if (dailyService.deleteDailyBoard(board_no) > 0) {
            if (renameFileName != null) {
                String savePath = request.getSession().getServletContext().getRealPath(
                        "resources/daily_upfiles");

                new File(savePath + "\\" + renameFileName).delete();
            }
            return "redirect:dailylist.do";
        } else {
            model.addAttribute("message", board_no + "번 글삭제 실패");
            return "common/error";
        }
    }

    //좋아요 증가
    @RequestMapping("dailylikeCountUp.do")
    public String dailyLikeCountInsertMethod(
            @RequestParam("board_no") int board_no,
            @RequestParam("user_id") String user_id,
            Model model) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("board_no", board_no);
        params.put("user_id", user_id);

        if (dailyService.insertDailyLike(params) > 0) {
            if (dailyService.updateDailyLikeCount(board_no) > 0) {
                model.addAttribute("board_no", board_no);
                return "redirect:dailydetail.do?board_no=" + board_no;
            } else {
                System.out.println("증가 안됨");
            }
        } else {
            System.out.println("like테이블 insert 안 됨");
        }
        return "redirect:dailydetail.do?board_no=" + board_no;

    }

    //좋아요 감소
    @RequestMapping("dailylikeCountDown.do")
    public String dailyUnLikeCountInsertMethod(
            @RequestParam("board_no") int board_no,
            @RequestParam("user_id") String user_id,
            Model model) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("board_no", board_no);
        params.put("user_id", user_id);

        if (dailyService.deleteDailyLike(params) > 0) {
            if (dailyService.updateDailyLikeCount(board_no) > 0) {
                model.addAttribute("board_no", board_no);
                return "redirect:dailydetail.do?board_no=" + board_no;
            } else {
                System.out.println("감소 안됨");
            }
        } else {
            System.out.println("like테이블 delete 안 됨");
        }
        return "redirect:dailydetail.do?board_no=" + board_no;

    }
}
