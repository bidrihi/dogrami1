package com.cono.dogrami.infoshare.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.cono.dogrami.infoshare.model.service.InfoshareService;
import com.cono.dogrami.infoshare.model.vo.Infoshare;
import com.cono.dogrami.infosharereply.model.service.InfoshareReplyService;
import com.cono.dogrami.infosharereply.model.vo.InfoshareReply;
import com.cono.dogrami.member.model.vo.Member;
import com.cono.dogrami.common.Paging;

@Controller
public class InfoshareController {
    private static final Logger logger = LoggerFactory.getLogger(InfoshareController.class);

    @Autowired
    private InfoshareService infoshareService;
    
    @Autowired
    private InfoshareReplyService infoshareReplyService;
    
    //게시글 전체 목록보기 (페이징처리 후)
  	@RequestMapping("infosharelist.do")
  	public ModelAndView infoshareListMethod(@RequestParam(name = "page", required = false) String page, ModelAndView mv) {
  		
  		int currentPage = 1;
  		if (page != null) {
  			currentPage = Integer.parseInt(page);
  		}

  		// 한 페이지에 게시글 10개씩 출력되게 하는 경우 :
  		// 페이징 계산 처리 - 별도의 클래스로 작성해서 이용해도 됨
  		int limit = 10; // 한 페이지에 출력할 목록 갯수
  		// 총 페이지 수 계산을 위해 게시글 총 갯수 조회해 옴
  		int listCount = infoshareService.selectListCount();
  		String url = "infosharelist.do";
  		Paging paging = new Paging(listCount, currentPage, limit, url);
  		paging.calculator();
  		logger.info("page : " + page);
  		
  		ArrayList<Infoshare> list = infoshareService.selectList(paging);
  		
  		 //댓글 갯수 list
        ArrayList<Integer> replycount = new ArrayList<Integer>();

  		for(int i = 0; i < list.size(); i++) {
  	         int count = infoshareReplyService.selectInfoshareReplyCount(list.get(i).getBoard_no());
  	         replycount.add(count);
  	     }
  		
  		if(list != null && list.size() > 0) {
  			mv.addObject("list",list);
  			mv.addObject("paging", paging);
  			mv.addObject("replycount", replycount);
  			mv.setViewName("infoshare/infoshareListView");
  		}else {
  			mv.setViewName("infoshare/infoshareListView");
  		}
  		return mv;
  	}

	//게시글 상세보기
	@RequestMapping("infosharedetail.do")
	public ModelAndView infoshareDetailMethod(
			ModelAndView mv, @RequestParam("board_no") int board_no,
			@RequestParam(name="page", required = false) String page,
			HttpServletRequest request) {
		
		//페이징
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		//조회수 1증가 처리 (조회숫자만 증가하면 되기때문에 반환값 안 받음)
		infoshareService.updateInfoshareBoardReadcount(board_no);
		
		//해당 게시글 조회
		Infoshare infoshare = infoshareService.selectInfoshareBoard(board_no);
		
		//댓글 리스트 불러오기
		ArrayList<InfoshareReply> infosharereply = infoshareReplyService.selectList(board_no);
		
		//댓글 갯수
		int replycount = infoshareReplyService.selectInfoshareReplyCount(board_no);
		
		//좋아요 체크
		HttpSession session = request.getSession();
		String likeResult = "N";
		
		if (session.getAttribute("loginMember") != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("board_no", board_no);
			params.put("user_id", ((Member) session.getAttribute("loginMember")).getUser_id());

			if (infoshareService.selectInfoshareLikeCheck(params) != null) {
				likeResult = "Y";
			}
		}
		
		if(infoshare != null) {
			mv.addObject("infoshare",infoshare);
			mv.addObject("infosharereply",infosharereply);
			mv.addObject("replycount",replycount);
			mv.addObject("currentPage", currentPage);
			mv.addObject("likeResult", likeResult);
			mv.setViewName("infoshare/infoshareDetailView");
		} else {
			mv.addObject("message", board_no + "번 게시글 조회 실패!");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	//게시글 작성폼으로 이동
	@RequestMapping("infosharewrite.do")
    public String moveInfoshareWriteForm() {
    	return "infoshare/infosharewriteform";
    }
	
	//게시글 작성하기
	@RequestMapping(value="infoshareinsert.do", method=RequestMethod.POST)
	public String infoshareInsertMethod(Infoshare infoshare, Model model, HttpServletRequest request, @RequestParam(name="upfile", required=false) MultipartFile mfile) {
		
		//게시글 첨부파일 저장 폴더 경로 지정
		String savePath = request.getSession()
				.getServletContext().getRealPath(
					"resources/infoshare_upfiles");
				
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
				infoshare.setBoard_old_file(fileName);
				infoshare.setBoard_new_file(renameFileName);
			} //이름바꾸기
		}  //새로운 첨부파일이 있을 때		
		
		if(infoshareService.insertInfoshareBoard(infoshare) > 0) {
			return "redirect:infosharelist.do";
		}else {
			model.addAttribute("message", " 등록 실패");
			return "common/error";
		}
	}
	
	//파일다운로드
	@RequestMapping("infosharefdown.do")
	public ModelAndView infosharefileDownMethod(
			ModelAndView mv, HttpServletRequest request,
			@RequestParam("oldfile") String originalFileName,
			@RequestParam("newfile") String renameFileName) {
		//공지사항 첨부파일 저장폴더에 대한 경로(path) 지정
		String savePath = request.getSession()
				.getServletContext().getRealPath(
						"resources/infoshare_upfiles");
		
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
	@RequestMapping("infoshareupview.do")
	public String moveInfoshareUpdateView(
			@RequestParam("board_no") int board_no,
			Model model) {
		
		Infoshare infoshare = infoshareService.selectInfoshareBoard(board_no);
		String nickname = infoshareService.selectnickname(board_no);
		
		if(infoshare != null) {
			model.addAttribute("infoshare", infoshare);
			model.addAttribute("nickname",nickname);
			return "infoshare/infoshareUpdateForm";
		} else {
			model.addAttribute("message", board_no + "에 대한 게시글 정보가 없습니다");
			return "common/error";
		}
	}
	
	//게시글 수정하기 
	  @RequestMapping(value = "infoshareupdate.do", method = RequestMethod.POST)
	    public String infoshareUpdateMethod(Infoshare infoshare, Model model, HttpServletRequest request,
	    		@RequestParam(name = "delfile", required = false) String delFlag,
	    		@RequestParam(name = "upfile", required = false) MultipartFile mfile) {

	        //게시원글 첨부파일 저장 폴더 경로 지정
	        String savePath =
	        		request.getSession().getServletContext().getRealPath("resources/infoshare_upfiles");

	        //첨부파일이 수정 처리된 경우 ---------------------------
	        //1. 원래 첨부파일이 있는데 '파일삭제'를 선택한 경우
	        if (infoshare.getBoard_old_file() != null && delFlag != null && delFlag.equals("yes")) {
	            //저장 폴더에 있는 파일을 삭제함
	            new File(savePath + "\\" + infoshare.getBoard_new_file()).delete();
	            //infoshare 의 파일 정보도 제거함
	            infoshare.setBoard_old_file(null);
	            infoshare.setBoard_new_file(null);
	        }

	        //2. 게시글 첨부파일은 1개만 가능한 경우
	        //새로운 첨부파일이 있을때
	        if (!mfile.isEmpty()) {
	            //2-1. 이전 첨부파일이 있을 때
	            if (infoshare.getBoard_old_file() != null) {
	                //저장 폴더에 있는 이전 파일을 삭제함
	                new File(savePath + "\\" + infoshare.getBoard_new_file()).delete();
	                //infoshare 의 이전 파일 정보도 제거함
	                infoshare.setBoard_old_file(null);
	                infoshare.setBoard_new_file(null);
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

	                //infoshare 객체에 첨부파일 정보 기록 저장
	                infoshare.setBoard_old_file(fileName);
	                infoshare.setBoard_new_file(renameFileName);
	            } //이름바꾸기
	        }  //새로운 첨부파일이 있을 때

	        if (infoshareService.updateInfoshareBoard(infoshare) > 0) {
	            //게시글 수정 성공시 상세보기 페이지로 이동
	            model.addAttribute("board_no", infoshare.getBoard_no());
	            return "redirect:infosharedetail.do?board_no="+ infoshare.getBoard_no() ;
	        } else {
	            model.addAttribute("message", infoshare.getBoard_no() + "번 게시글 수정 실패!");
	            return "common/error";
	        }
	    }
	
	  //게시글 검색하기
	  @RequestMapping(value="infosharesearch.do", method= {RequestMethod.GET, RequestMethod.POST})
	  public ModelAndView infoshareSearchMethod(
			  @RequestParam("action") String action,
			  @RequestParam(name = "page", required = false) String page,
			  @RequestParam("keyword") String keyword, 
			  ModelAndView mv) {
		  
		  ArrayList<Infoshare> list = null;
		  int currentPage = 1;
		  if (page != null) {
				currentPage = Integer.parseInt(page);
			}
		  int limit = 10;
		  int listCount = 0;
		  String url = "infosharesearch.do";
		  Paging paging = new Paging(listCount, currentPage, limit, url);
		  
		  listCount = infoshareService.selectListCountSearch(action, keyword);
		  paging.setListCount(listCount);
		  paging.calculator();
		  list = infoshareService.selectSearch(action, keyword, paging);
		  
	  		 //댓글 갯수 list
	        ArrayList<Integer> replycount = new ArrayList<Integer>();
	        
	    	for(int i = 0; i < list.size(); i++) {

	  	         int count = infoshareReplyService.selectInfoshareReplyCount(list.get(i).getBoard_no());
	  	         replycount.add(count);
	  	        
	  	     }
		  
		  if(list != null && list.size() > 0) {
			  	mv.addObject("list", list);
		  		mv.addObject("action", action);
		  		mv.addObject("keyword", keyword);
		  		mv.addObject("paging", paging);
		  		mv.addObject("replycount",replycount);
		  		mv.setViewName("infoshare/infoshareListView");
		  } else {
		  		mv.setViewName("redirect:infosharelist.do");
		  }
		  
		  return mv;
		
	  }
	  
	  //게시글 삭제 (댓글은 오라클 cascade제약조건으로 같이 삭제됨)
	  @RequestMapping("infosharedelete.do")
	  public String  infoshareDeleteMethod(
			  @RequestParam("board_no") int board_no,
			  @RequestParam(name="board_new_file", required=false) String renameFileName,
			  HttpServletRequest request, Model model) {
		  
		  if(infoshareService.deleteInfoshareBoard(board_no) > 0) {
			  if(renameFileName != null) {
				  String savePath = request.getSession().getServletContext().getRealPath(
						  "resources/infoshare_upfiles");
				  
				  new File(savePath + "\\" + renameFileName).delete();
			  }
			  return "redirect:infosharelist.do";
		  } else {
			  model.addAttribute("message",board_no + "번 글삭제 실패");
			  return "common/error";
		  }
	  }
	  
	  //좋아요 증가
	  @RequestMapping("infosharelikeCountUp.do")
	  public String infoshareLikeCountInsertMethod(
			  @RequestParam("board_no") int board_no,
			  @RequestParam("user_id") String user_id,
			  Model model) {
		  Map<String, Object> params = new HashMap<String, Object>();
		  params.put("board_no", board_no);
		  params.put("user_id", user_id);		  

		  if(infoshareService.insertInfoshareLike(params) > 0) {
			  if(infoshareService.updateInfoshareLikeCount(board_no) > 0) {
			  model.addAttribute("board_no", board_no);
			  return "redirect:infosharedetail.do?board_no=" + board_no ;
			  }else {
				  System.out.println("증가 안됨");
			  }
		  }  else {
			  System.out.println("like테이블 insert 안 됨");
		  }
		  return "redirect:infosharedetail.do?board_no=" + board_no ;

	  }
	  
	  //좋아요 감소
	  @RequestMapping("infosharelikeCountDown.do")
	  public String infoshareUnLikeCountInsertMethod(
			  @RequestParam("board_no") int board_no,
			  @RequestParam("user_id") String user_id,
			  Model model) {
		  Map<String, Object> params = new HashMap<String, Object>();
		  params.put("board_no", board_no);
		  params.put("user_id", user_id);		  

		  if(infoshareService.deleteInfoshareLike(params) > 0) {
			  if(infoshareService.updateInfoshareLikeCount(board_no) > 0) {
			  model.addAttribute("board_no", board_no);
			  return "redirect:infosharedetail.do?board_no=" + board_no ;
			  }else {
				  System.out.println("감소 안됨");
			  }
		  }  else {
			  System.out.println("like테이블 delete 안 됨");
		  }
		  return "redirect:infosharedetail.do?board_no=" + board_no ;

	  }
}
