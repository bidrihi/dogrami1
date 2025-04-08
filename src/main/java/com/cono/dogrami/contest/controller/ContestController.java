package com.cono.dogrami.contest.controller;

import com.cono.dogrami.common.FileNameChange;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.contest.model.service.ContestService;
import com.cono.dogrami.contest.model.vo.Contest;
import com.cono.dogrami.member.model.vo.Member;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ContestController {

    @Autowired
    private ContestService contestService;

    //메인 최신 게시글 보기
    @RequestMapping(value = "connew5.do", method = RequestMethod.POST)
    @ResponseBody
    public String contestNewTop5Method() throws UnsupportedEncodingException {
        ArrayList<Contest> list = contestService.selectNewTop5();

        JSONObject sendJson = new JSONObject();
        JSONArray jarr = new JSONArray();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (Contest contest : list) {
            JSONObject job = new JSONObject();

            job.put("contest_no", contest.getContest_no());
            job.put("contest_title", URLEncoder.encode(contest.getContest_title(), "utf-8"));
            job.put("contest_date", sdf.format(contest.getContest_date()));
            job.put("like_count", contest.getLike_count());

            jarr.add(job);
        }

        sendJson.put("list", jarr);

        return sendJson.toJSONString();
    }

    //메인 좋아요 가장 많은 게시글 보기
    @RequestMapping(value = "contop4.do", method = RequestMethod.POST)
    @ResponseBody
    public String contestTop5Method() throws UnsupportedEncodingException {
        ArrayList<Contest> list = contestService.selectTop5();

        JSONObject sendJson = new JSONObject();
        JSONArray jarr = new JSONArray();

        for (Contest contest : list) {
            JSONObject job = new JSONObject();

            job.put("contest_no", contest.getContest_no());
            job.put("contest_title", URLEncoder.encode(contest.getContest_title(), "utf-8"));
            job.put("contest_content", URLEncoder.encode(contest.getContest_content(), "utf-8"));
            job.put("contest_newfile", contest.getContest_newfile());

            jarr.add(job);
        }

        sendJson.put("list", jarr);

        return sendJson.toJSONString();
    }

    //게시글 전체 목록보기 (페이징처리 후)
    @RequestMapping("contestlist.do")
    public ModelAndView contestListMethod(@RequestParam(name = "page", required = false) String page, ModelAndView mv) {

        int currentPage = 1;
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }

        // 한 페이지에 게시글 10개씩 출력되게 하는 경우 :
        // 페이징 계산 처리 - 별도의 클래스로 작성해서 이용해도 됨
        int limit = 10; // 한 페이지에 출력할 목록 갯수
        // 총 페이지 수 계산을 위해 게시글 총 갯수 조회해 옴
        int listCount = contestService.selectListCount();
        String url = "contestlist.do";
        Paging paging = new Paging(listCount, currentPage, limit, url);
        paging.calculator();

        ArrayList<Contest> list = contestService.selectList(paging);

        if (list != null && list.size() > 0) {
            mv.addObject("list", list);
            mv.addObject("paging", paging);

            mv.setViewName("contest/contestListView");
        } else {
            mv.setViewName("contest/contestListView");
        }
        return mv;
    }

    //게시글 상세보기
    @RequestMapping("contestdetail.do")
    public ModelAndView contestDetailMethod(
            ModelAndView mv, @RequestParam("contest_no") int contest_no, HttpServletRequest request,
            @RequestParam(name = "page", required = false) String page) {

        int currentPage = 1;
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }

        //조회수 1증가 처리 (조회숫자만 증가하면 되기때문에 반환값 안 받음)
        contestService.updateContestBoardReadcount(contest_no);

        //해당 게시글 조회
        Contest contest = contestService.selectContestBoard(contest_no);

        HttpSession session = request.getSession();
        String likeResult = "N";

        if (session.getAttribute("loginMember") != null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("contest_no", contest_no);
            params.put("user_id", ((Member) session.getAttribute("loginMember")).getUser_id());

            if (contestService.selectContestLikeCheck(params) != null) {
                likeResult = "Y";
            }
        }

        if (contest != null) {
            mv.addObject("contest", contest);

            mv.addObject("likeResult", likeResult);
            mv.addObject("currentPage", currentPage);
            mv.setViewName("contest/contestDetailView");
        } else {
            mv.addObject("message", contest_no + "번 게시글 조회 실패!");
            mv.setViewName("common/error");
        }
        return mv;
    }

    //게시글 작성폼으로 이동
    @RequestMapping("contestwrite.do")
    public String movecontestWriteForm() {
        return "contest/contestwriteform";
    }

    //게시글 작성하기
    @RequestMapping(value = "contestinsert.do", method = RequestMethod.POST)
    public String contestInsertMethod(Contest contest, Model model, HttpServletRequest request, @RequestParam(name = "upfile", required = false) MultipartFile mfile) {

        //게시글 첨부파일 저장 폴더 경로 지정
        String savePath = request.getSession().getServletContext().getRealPath("resources/contest_upfiles");

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

                String renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");

                //파일 객체 만들기
                File renameFile = new File(savePath + "\\" + renameFileName);

                //폴더에 저장 처리
                try {
                    mfile.transferTo(renameFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("message", "첨부파일 저장 실패!");
                    return "common/error";
                }

                contest.setContest_oldfile(fileName);
                contest.setContest_newfile(renameFileName);
            } //이름바꾸기
        }  //새로운 첨부파일이 있을 때

        if (contestService.insertContestBoard(contest) > 0) {
            return "redirect:contestlist.do";
        } else {
            model.addAttribute("message", " 등록 실패");
            return "common/error";
        }
    }

    //파일다운로드
    @RequestMapping("contestfdown.do")
    public ModelAndView contestfileDownMethod(ModelAndView mv, HttpServletRequest request, @RequestParam("oldfile") String originalFileName, @RequestParam("newfile") String renameFileName) {
        //공지사항 첨부파일 저장폴더에 대한 경로(path) 지정
        String savePath = request.getSession().getServletContext().getRealPath("resources/contest_upfiles");

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
    @RequestMapping("contestupview.do")
    public String moveContestUpdateView(@RequestParam("contest_no") int contest_no, Model model) {

        Contest contest = contestService.selectContestBoard(contest_no);
        String nickname = contestService.selectnickname(contest_no);

        if (contest != null) {
            model.addAttribute("contest", contest);
            model.addAttribute("nickname", nickname);
            return "contest/contestUpdateForm";
        } else {
            model.addAttribute("message", contest_no + "에 대한 게시글 정보가 없습니다");
            return "common/error";
        }
    }

    //게시글 수정하기
    @RequestMapping(value = "contestupdate.do", method = RequestMethod.POST)
    public String contestUpdateMethod(Contest contest, Model model, HttpServletRequest request,
                                      @RequestParam(name = "delfile", required = false) String delFlag,
                                      @RequestParam(name = "upfile", required = false) MultipartFile mfile) {

        //게시원글 첨부파일 저장 폴더 경로 지정
        String savePath =
                request.getSession().getServletContext().getRealPath("resources/contest_upfiles");

        //첨부파일이 수정 처리된 경우 ---------------------------
        //1. 원래 첨부파일이 있는데 '파일삭제'를 선택한 경우
        if (contest.getContest_oldfile() != null && delFlag != null && delFlag.equals("yes")) {
            //저장 폴더에 있는 파일을 삭제함
            new File(savePath + "\\" + contest.getContest_newfile()).delete();

            contest.setContest_oldfile(null);
            contest.setContest_newfile(null);
        }

        //2. 게시글 첨부파일은 1개만 가능한 경우
        //새로운 첨부파일이 있을때
        if (!mfile.isEmpty()) {
            //2-1. 이전 첨부파일이 있을 때
            if (contest.getContest_oldfile() != null) {
                //저장 폴더에 있는 이전 파일을 삭제함
                new File(savePath + "\\" + contest.getContest_newfile()).delete();

                contest.setContest_oldfile(null);
                contest.setContest_newfile(null);
            }

            //2-2. 이전 첨부파일이 없을 때
            //전송온 파일이름 추출함
            String fileName = mfile.getOriginalFilename();

            //다른 게시글의 첨부파일과 파일명이 중복되어서 덮어쓰기 되는것을 막기 위해, 파일명을 변경해서
            //폴더에 저장하는 방식을 사용할 수 있음
            //변경 파일명 : 년월일시분초.확장자
            if (fileName != null && fileName.length() > 0) {
                String renameFileName = FileNameChange.change(fileName, "yyyyMMddHHmmss");
                //폴더에 저장 처리
                try {
                    mfile.transferTo(new File(savePath + "\\" + renameFileName));
                } catch (Exception e) {
                    e.printStackTrace();
                    model.addAttribute("message", "첨부파일 저장 실패!");
                    return "common/error";
                }
                contest.setContest_oldfile(fileName);
                contest.setContest_newfile(renameFileName);
            } //이름바꾸기
        }  //새로운 첨부파일이 있을 때

        if (contestService.updateContestBoard(contest) > 0) {
            //게시글 수정 성공시 상세보기 페이지로 이동
            model.addAttribute("contest_no", contest.getContest_no());
            return "redirect:contestlist.do";
        } else {
            model.addAttribute("message", contest.getContest_no() + "번 게시글 수정 실패!");
            return "common/error";
        }
    }

    //게시글 검색하기
    @RequestMapping(value = "contestsearch.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView contestSearchMethod(
            @RequestParam("action") String action,
            @RequestParam(name = "page", required = false) String page,
            @RequestParam("keyword") String keyword,
            ModelAndView mv) {

        ArrayList<Contest> list = null;
        int currentPage = 1;
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }
        int limit = 10;
        int listCount = 0;
        String url = "contestsearch.do";
        Paging paging = new Paging(listCount, currentPage, limit, url);

        listCount = contestService.selectListCountSearch(action, keyword);
        paging.setListCount(listCount);
        paging.calculator();
        list = contestService.selectSearch(action, keyword, paging);


        if (list != null && list.size() > 0) {
            mv.addObject("list", list);
            mv.addObject("action", action);
            mv.addObject("keyword", keyword);
            mv.addObject("paging", paging);

            mv.setViewName("contest/contestListView");
        } else {
            mv.addObject("message", keyword + "로 검색된 게시글 정보가 없습니다.");
            mv.setViewName("common/error");
        }

        return mv;

    }

    //게시글 삭제 (댓글은 오라클 cascade제약조건으로 같이 삭제됨)
    @RequestMapping("contestdelete.do")
    public String contestDeleteMethod(
            @RequestParam("contest_no") int contest_no,
            @RequestParam(name = "contest_newfile", required = false) String renameFileName,
            HttpServletRequest request, Model model) {

        if (contestService.deleteContestBoard(contest_no) > 0) {
            if (renameFileName != null) {
                String savePath = request.getSession().getServletContext().getRealPath(
                        "resources/contest_upfiles");

                new File(savePath + "\\" + renameFileName).delete();
            }
            return "redirect:contestlist.do";
        } else {
            model.addAttribute("message", contest_no + "번 글삭제 실패");
            return "common/error";
        }
    }

    @RequestMapping("contestlike.do")
    public String contestLikeMethod(Contest contest, Model model) {


        if (contestService.selectLike(contest) == null) {
            contestService.insertLike(contest);
            contestService.updateuLike(contest);
            return "redirect:contestdetail.do?contest_no=" + contest.getContest_no();
        } else {
            contestService.deleteLike(contest);
            contestService.updatedLike(contest);
            return "redirect:contestdetail.do?contest_no=" + contest.getContest_no();
        }
    }

    @RequestMapping("contestlikeCountUp.do")
    public String contestLikeCountInsertMethod(
            @RequestParam("contest_no") int contest_no,
            @RequestParam("user_id") String user_id,
            Model model) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("contest_no", contest_no);
        params.put("user_id", user_id);

        if (contestService.insertContestLike(params) > 0) {
            if (contestService.updateContestLikeCount(contest_no) > 0) {
                model.addAttribute("contest_no", contest_no);
                return "redirect:contestdetail.do?contest_no=" + contest_no;
            } else {
                System.out.println("증가 안됨");
            }
        } else {
            System.out.println("like테이블 insert 안 됨");
        }
        return "redirect:contestdetail.do?contest_no=" + contest_no;

    }

    //좋아요 감소
    @RequestMapping("contestlikeCountDown.do")
    public String contestUnLikeCountInsertMethod(
            @RequestParam("contest_no") int contest_no,
            @RequestParam("user_id") String user_id,
            Model model) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("contest_no", contest_no);
        params.put("user_id", user_id);

        if (contestService.deleteContestLike(params) > 0) {
            if (contestService.updateContestLikeCount(contest_no) > 0) {
                model.addAttribute("contest_no", contest_no);
                return "redirect:contestdetail.do?contest_no=" + contest_no;
            } else {
                System.out.println("감소 안됨");
            }
        } else {
            System.out.println("like테이블 delete 안 됨");
        }
        return "redirect:contestdetail.do?contest_no=" + contest_no;

    }
}
