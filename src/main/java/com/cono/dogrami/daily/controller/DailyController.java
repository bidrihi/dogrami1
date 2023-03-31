package com.cono.dogrami.daily.controller;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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

import com.cono.dogrami.common.FileNameChange;
import com.cono.dogrami.daily.model.service.DailyService;
import com.cono.dogrami.daily.model.vo.Daily;

@Controller
public class DailyController {
    private static final Logger logger = LoggerFactory.getLogger(DailyController.class);

    @Autowired
    private DailyService dailyService;
    
    
	//게시글 전체 목록보기 요청 처리용
	@RequestMapping("dailylist.do")
	public String dailyListMethod(Model model) {
		
		ArrayList<Daily> list = dailyService.selectList();
		//String nickname = dailyService.selectnickname(board_no);
		
		if(list != null && list.size() > 0) {
			model.addAttribute("list",list);
			//model.addAttribute("nickname",nickname);
			return "board/dailyListView" ;
		}else {
			model.addAttribute("message", "등록된 게시글 정보가 없습니다...;");
			return "common/error";
		}
	}
    

	//게시글 상세보기 처리용
	@RequestMapping("dailydetail.do")
	public ModelAndView dailyDetailMethod(
			ModelAndView mv, @RequestParam("board_no") int board_no) {

		//조회수 1증가 처리 (조회숫자만 증가하면 되기때문에 반환값 안 받음)
		dailyService.updateDailyBoardReadcount(board_no);
		//해당 게시글 조회
		Daily daily = dailyService.selectDailyBoard(board_no);
		String nickname = dailyService.selectnickname(board_no);
		
		if(daily != null) {
			mv.addObject("daily",daily);
			mv.addObject("nickname",nickname);
			mv.setViewName("board/dailyDetailView");
		} else {
			mv.addObject("message", board_no + "번 게시글 조회 실패!");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	//게시글 작성폼으로 이동
	@RequestMapping("dailywrite.do")
    public String moveDailyWriteForm() {
    	return "board/dailywriteform";
    }
	
	//게시글 작성하기
	@RequestMapping(value="dailyinsert.do", method=RequestMethod.POST)
	public String dailyInsertMethod(
			Daily daily, Model model, 
			HttpServletRequest request,			
			@RequestParam(name="upfile", required=false) MultipartFile mfile) {
		
		//게시글 첨부파일 저장 폴더 경로 지정
		String savePath = request.getSession()
				.getServletContext().getRealPath(
					"resources/daily_upfiles");
				
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
		
		if(dailyService.insertDailyBoard(daily) > 0) {
			return "redirect:dailylist.do";
		}else {
			model.addAttribute("message", " 등록 실패!");
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
		
		if(daily != null) {
			model.addAttribute("daily", daily);
			model.addAttribute("nickname",nickname);
			return "board/dailyUpdateForm";
		} else {
			model.addAttribute("message", board_no + "에 대한 게시글 정보가 없습니다");
			return "common/error";
		}
	}
	
	//게시글 수정하기 
	  @RequestMapping(value = "dailyupdate.do", method = RequestMethod.POST)
	    public String boardUpdateMethod(Daily daily, Model model, HttpServletRequest request,
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
	            return "redirect:dailylist.do";
	        } else {
	            model.addAttribute("message", daily.getBoard_no() + "번 게시글 수정 실패!");
	            return "common/error";
	        }
	    }
	
	  //게시글 검색하기
	  @RequestMapping(value="dailysearch.do", method=RequestMethod.POST)
	  public String dailySearchMethod(
			  @RequestParam("keyField") String keyField,
			  @RequestParam("keyword") String keyword, 
			  Model model) {
		  
		  	if(keyField.equals("board_title")) {
		  		ArrayList<Daily> list = dailyService.selectDailyBoardtitle(keyword);
		  		if(list != null && list.size() > 0) {
		  			model.addAttribute("list",list);
		  			return "board/dailyListView";
		  		} else {
		  			model.addAttribute("message", keyword +"로 검색된 게시글 정보가 없습니다.");
		  			return "common/error";
		  		}		
		  	} 
		  	
		  	if(keyField.equals("board_writer")) {
		  		ArrayList<Daily> list = dailyService.selectDailyBoardwriter(keyword);
		  		if(list != null && list.size() > 0) {
		  			model.addAttribute("list",list);
		  			return "board/dailyListView";
		  		} else {
		  			model.addAttribute("message", keyword +"로 검색된 게시글 정보가 없습니다.");
		  			return "common/error";
		  		}		
		  	} 
		  	
		  	if(keyField.equals("board_content")) {
		  		ArrayList<Daily> list = dailyService.selectDailyBoardcontent(keyword);
		  		if(list != null && list.size() > 0) {
		  			model.addAttribute("list",list);
		  			return "board/dailyListView";
		  		} else {
		  			model.addAttribute("message", keyword +"로 검색된 게시글 정보가 없습니다.");
		  			return "common/error";
		  		}		
		  	} else {
		  		return "redirect:dailylist.do";
		  	}
	  }
}
