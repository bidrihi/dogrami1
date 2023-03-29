package com.cono.dogrami.daily.controller;

import com.cono.dogrami.daily.model.service.DailyService;
import com.cono.dogrami.daily.model.vo.Daily;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.ict.first.board.model.vo.Board;
import org.ict.first.common.FileNameChange;
import org.ict.first.common.Paging;
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

@Controller
public class DailyController {
    private static final Logger logger = LoggerFactory.getLogger(DailyController.class);

    @Autowired
    private DailyService dailyService;
    
    
	//게시글 전체 목록보기 요청 처리용
	@RequestMapping("dailyboardlist.do")
	public String dailyboardListMethod(Model model) {
		
		ArrayList<Daily> list = dailyService.selectList();
		
		if(list != null && list.size() > 0) {
			model.addAttribute("list",list);
			return "board/dailyboardListView" ;
		}else {
			model.addAttribute("message", "등록된 게시글 정보가 없습니다...;");
			return "common/error";
		}
	}
    

	//게시글 상세보기 처리용
	@RequestMapping("dailyboarddetail.do")
	public ModelAndView dailyboardboardDetailMethod(
			ModelAndView mv, @RequestParam("board_no") int board_no) {

		//조회수 1증가 처리 (조회숫자만 증가하면 되기때문에 반환값 안 받음)
		dailyService.updateDailyBoardReadcount(board_no);
		//해당 게시글 조회
		Daily daily = dailyService.selectDailyBoard(board_no);
		String nickname = dailyService.selectnickname(board_no);
		
		if(daily != null) {
			mv.addObject("daily",daily);
			mv.addObject("nickname",nickname);
			mv.setViewName("board/dailyboardDetailView");
		} else {
			mv.addObject("message", board_no + "번 게시글 조회 실패!");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	//게시글 작성폼으로 이동
	@RequestMapping("dailyboardwrite.do")
    public String moveDailyBoardWriteForm() {
    	return "board/dailyboardwriteform";
    }
	
	//게시글 작성하기
	@RequestMapping(value="dailyboardinsert.do", method=RequestMethod.POST)
	public String dailyboardInsertMethod(
			Daily daily, Model model, 
			HttpServletRequest request,			
			@RequestParam(name="upfile", required=false) MultipartFile mfile) {
		
		//게시글 첨부파일 저장 폴더 경로 지정
		String savePath = request.getSession()
				.getServletContext().getRealPath(
					"resources/dailyboard_upfiles");
				
		//첨부파일이 있을때
		if(!mfile.isEmpty()) {
			
			//전송온 파일이름 추출함
			String fileName = mfile.getOriginalFilename();
			
			//다른 공지글의 첨부파일과 파일명이 중복되어서
			//덮어쓰기 되는것을 막기 위해, 파일명을 변경해서 
			//폴더에 저장하는 방식을 사용할 수 있음
			//변경 파일명 : 년월일시분초.확장자
			if(fileName != null && fileName.length() > 0) {
				//바꿀 파일명에 대한 문자열 만들기
				
				String renameFileName = com.cono.dogrami.common.FileNameChange.change
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
		
		if(dailyService.insertDailyBoard(daily) > 0) {
			return "redirect:dailyboardlist.do";
		}else {
			model.addAttribute("message", " 등록 실패!");
			return "common/error";
		}
	}
}
