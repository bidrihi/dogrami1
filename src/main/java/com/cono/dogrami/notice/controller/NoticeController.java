package com.cono.dogrami.notice.controller;

import com.cono.dogrami.common.FileNameChange;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.notice.model.service.NoticeService;
import com.cono.dogrami.notice.model.vo.Notice;
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
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class NoticeController {


    @Autowired
    private NoticeService noticeService;

    //풋터 최신 공지사항 보기
    @RequestMapping(value = "ntop5.do", method = RequestMethod.POST)
    @ResponseBody
    public String noticeNewTop5Method() throws UnsupportedEncodingException {
        ArrayList<Notice> list = noticeService.selectNewTop5();

        JSONObject sendJson = new JSONObject();
        JSONArray jarr = new JSONArray();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (Notice notice : list) {
            JSONObject job = new JSONObject();

            job.put("notice_no", notice.getNotice_no());
            job.put("notice_title", URLEncoder.encode(notice.getNotice_title(), "utf-8"));
            job.put("notice_date", sdf.format(notice.getNotice_date()));

            jarr.add(job);
        }

        sendJson.put("list", jarr);

        return sendJson.toJSONString();
    }

    //공지 리스트 보기
    @RequestMapping("nlist.do")
    public ModelAndView noticeListMethod(@RequestParam(name = "page", required = false) String page, ModelAndView mv) {

        int currentPage = 1;
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }

        // 한 페이지에 게시글 10개씩 출력되게 하는 경우 :
        // 페이징 계산 처리 - 별도의 클래스로 작성해서 이용해도 됨
        int limit = 10; // 한 페이지에 출력할 목록 갯수
        // 총 페이지 수 계산을 위해 게시글 총 갯수 조회해 옴
        int listCount = noticeService.selectListCount();
        String url = "nlist.do";
        Paging paging = new Paging(listCount, currentPage, limit, url);
        paging.calculator();

        ArrayList<Notice> list = noticeService.selectList(paging);

        if (list != null && list.size() > 0) {
            mv.addObject("list", list);
            mv.addObject("paging", paging);
            mv.setViewName("notice/noticeListView");
        } else {
            mv.setViewName("notice/noticeListView");
        }
        return mv;
    }

    //공지 상세보기
    @RequestMapping("noticedetail.do")
    public ModelAndView noticeDetailMethod(ModelAndView mv, @RequestParam("notice_no") int notice_no, @RequestParam(name = "page", required = false) String page) {

        int currentPage = 1;
        if (page != null) {
            currentPage = Integer.parseInt(page);
        }

        //조회수 1증가 처리 (조회숫자만 증가하면 되기때문에 반환값 안 받음)
        noticeService.updateNoticeReadcount(notice_no);

        //해당 게시글 조회
        Notice notice = noticeService.selectNotice(notice_no);

        if (notice != null) {
            mv.addObject("notice", notice);
            mv.addObject("currentPage", currentPage);
            mv.setViewName("notice/noticeDetailView");
        } else {
            mv.addObject("message", notice_no + "번 게시글 조회 실패!");
            mv.setViewName("common/error");
        }
        return mv;
    }

    //공지 작성폼으로 이동
    @RequestMapping("noticewrite.do")
    public String moveNoticeWriteForm() {
        return "notice/noticeWriteForm";
    }

    //공지 작성하기
    @RequestMapping(value = "noticeinsert.do", method = RequestMethod.POST)
    public String noticeInsertMethod(Notice notice, Model model, HttpServletRequest request, @RequestParam(name = "upfile", required = false) MultipartFile mfile) {

        //게시글 첨부파일 저장 폴더 경로 지정
        String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");

        //첨부파일이 있을때
        if (!mfile.isEmpty()) {

            //전송온 파일이름 추출함
            String fileName = mfile.getOriginalFilename();

            //다른 공지글의 첨부파일과 파일명이 중복되어서 덮어쓰기 되는것을 막기 위해, 파일명을 변경해서  폴더에 저장하는 방식을 사용할 수 있음
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

                //객체에 첨부파일 정보 기록 저장
                notice.setNotice_old_file(fileName);
                notice.setNotice_new_file(renameFileName);
            }
        }

        if (noticeService.insertNotice(notice) > 0) {
            return "redirect:nlist.do";
        } else {
            model.addAttribute("message", " 등록 실패");
            return "common/error";
        }
    }

    //파일다운로드
    @RequestMapping("noticefdown.do")
    public ModelAndView noticefileDownMethod(ModelAndView mv, HttpServletRequest request, @RequestParam("oldfile") String originalFileName, @RequestParam("newfile") String renameFileName) {
        //공지사항 첨부파일 저장폴더에 대한 경로(path) 지정
        String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");

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

    //공지 수정폼으로 이동
    @RequestMapping("noticeupview.do")
    public String moveNoticeUpdateView(@RequestParam("notice_no") int notice_no, Model model) {

        Notice notice = noticeService.selectNotice(notice_no);

        if (notice != null) {
            model.addAttribute("notice", notice);
            //model.addAttribute("nickname",nickname);
            return "notice/noticeUpdateForm";
        } else {
            model.addAttribute("message", notice_no + "에 대한 게시글 정보가 없습니다");
            return "common/error";
        }
    }

    //공지 수정하기
    @RequestMapping(value = "noticeupdate.do", method = RequestMethod.POST)
    public String noticeUpdateMethod(Notice notice, Model model, HttpServletRequest request, @RequestParam(name = "delfile", required = false) String delFlag, @RequestParam(name = "upfile", required = false) MultipartFile mfile) {

        //게시원글 첨부파일 저장 폴더 경로 지정
        String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");

        //첨부파일이 수정 처리된 경우 ---------------------------
        //1. 원래 첨부파일이 있는데 '파일삭제'를 선택한 경우
        if (notice.getNotice_old_file() != null && delFlag != null && delFlag.equals("yes")) {
            //저장 폴더에 있는 파일을 삭제함
            new File(savePath + "\\" + notice.getNotice_new_file()).delete();
            //daily 의 파일 정보도 제거함
            notice.setNotice_old_file(null);
            notice.setNotice_new_file(null);
        }

        //2. 게시글 첨부파일은 1개만 가능한 경우
        //새로운 첨부파일이 있을때
        if (!mfile.isEmpty()) {
            //2-1. 이전 첨부파일이 있을 때
            if (notice.getNotice_old_file() != null) {
                //저장 폴더에 있는 이전 파일을 삭제함
                new File(savePath + "\\" + notice.getNotice_new_file()).delete();
                //이전 파일 정보도 제거함
                notice.setNotice_old_file(null);
                notice.setNotice_new_file(null);
            }

            //2-2. 이전 첨부파일이 없을 때 전송온 파일이름 추출함
            String fileName = mfile.getOriginalFilename();

            //다른 게시글의 첨부파일과 파일명이 중복되어서 덮어쓰기 되는것을 막기 위해, 파일명을 변경해서 폴더에 저장하는 방식을 사용할 수 있음
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

                //객체에 첨부파일 정보 기록 저장
                notice.setNotice_old_file(fileName);
                notice.setNotice_new_file(renameFileName);
            }
        }

        if (noticeService.updateNotice(notice) > 0) {
            //게시글 수정 성공시 상세보기 페이지로 이동
            model.addAttribute("notice_no", notice.getNotice_no());
            return "redirect:nlist.do";
        } else {
            model.addAttribute("message", notice.getNotice_no() + "번 게시글 수정 실패!");
            return "common/error";
        }
    }

    //공지 검색하기
    @RequestMapping(value = "noticesearch.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView noticeSearchMethod(
            @RequestParam("action") String action,
            @RequestParam(name = "page", required = false) String page,
            @RequestParam("keyword") String keyword,
            ModelAndView mv) {

        ArrayList<Notice> list = null;
        int currentPage = 1;

        if (page != null) {
            currentPage = Integer.parseInt(page);
        }

        int limit = 10;
        int listCount = 0;

        String url = "noticesearch.do";
        Paging paging = new Paging(listCount, currentPage, limit, url);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("action", action);
        params.put("keyword", keyword);

        listCount = noticeService.selectListCountSearch(params);
        paging.setListCount(listCount);
        paging.calculator();
        params.put("paging", paging);
        list = noticeService.selectSearch(params);

        if (list != null && list.size() > 0) {
            mv.addObject("list", list);
            mv.addObject("action", action);
            mv.addObject("keyword", keyword);
            mv.addObject("paging", paging);
            mv.setViewName("notice/noticeListView");
        } else {
            mv.addObject("message", keyword + "로 검색된 게시글 정보가 없습니다.");
            mv.setViewName("common/error");
        }

        return mv;
    }

    //공지 삭제
    @RequestMapping("noticedelete.do")
    public String noticeDeleteMethod(@RequestParam("notice_no") int notice_no, @RequestParam(name = "notice_new_file", required = false) String renameFileName, HttpServletRequest request, Model model) {

        if (noticeService.deleteNotice(notice_no) > 0) {
            if (renameFileName != null) {
                String savePath = request.getSession().getServletContext().getRealPath("resources/notice_upfiles");

                new File(savePath + "\\" + renameFileName).delete();
            }
            return "redirect:nlist.do";
        } else {
            model.addAttribute("message", notice_no + "번 글삭제 실패");
            return "common/error";
        }
    }
}
