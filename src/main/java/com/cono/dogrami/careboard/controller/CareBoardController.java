package com.cono.dogrami.careboard.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.cono.dogrami.careboard.model.service.CareBoardService;
import com.cono.dogrami.careboard.model.vo.CareBoard;
import com.cono.dogrami.carereply.model.service.CareReplyService;
import com.cono.dogrami.carereply.model.vo.CareReply;
import com.cono.dogrami.common.FileNameChange;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.member.model.vo.Member;

@Controller
public class CareBoardController {

	@Autowired
	private CareBoardService careBoardService;
	
	@Autowired
	private CareReplyService careReplyService;

	//메인 최신 게시글 보기
	@RequestMapping(value = "carenew5.do", method = RequestMethod.POST)
	@ResponseBody
	public String careNewTop5Method() throws UnsupportedEncodingException {
		ArrayList<CareBoard> list = careBoardService.selectNewTop5();

		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		for (CareBoard careBoard : list) {
			JSONObject job = new JSONObject();

			job.put("board_no", careBoard.getBoard_no());
			job.put("board_title", URLEncoder.encode(careBoard.getBoard_title(), "utf-8"));
			job.put("category", URLEncoder.encode(careBoard.getCategory(), "utf-8"));
			job.put("location", URLEncoder.encode(careBoard.getLocation(), "utf-8"));
			job.put("board_date", sdf.format(careBoard.getBoard_date()));

			jarr.add(job);
		}

		sendJson.put("list", jarr);

		return sendJson.toJSONString();
	}

	// Care 게시판
	// 게시글 페이지 단위로 목록보기 요청 처리용
	@RequestMapping("clist3.do")
	public ModelAndView careBoardList(
			@RequestParam(name = "page", required = false) String page, 
			ModelAndView mv) {
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		int limit = 10; // 한페이지에 10개씩 출력
		int listCount = careBoardService.selectListCount(); // 총글갯수 조회
		String url = "clist3.do";
		Paging paging = new Paging(listCount, currentPage, limit, url);
		paging.calculator();

		ArrayList<CareBoard> list = careBoardService.selectList(paging);

		if (list != null && list.size() >= 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.setViewName("careBoard/careBoardListView");
		} else {
			mv.addObject("message", "error");
			mv.setViewName("error/common");
		}
		return mv;
	}

	// 게시글 상세보기
	@RequestMapping("cdetail3.do")
	public ModelAndView careBoardDetail(@RequestParam("board_no") int board_no,
			@RequestParam(name = "page", required = false) String page,
			ModelAndView mv, HttpServletRequest request) {
		
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 조회수 1증가 처리(들어갈시)
		careBoardService.updateCount(board_no);

		// 해당 게시글 조회
		CareBoard careBoard = careBoardService.selectCareBoard(board_no);
		
		// 해당 게시글 댓글 조회
		ArrayList<CareReply> careReply = careReplyService.selectList(board_no);
		
		//댓글 갯수
		int replyCount = careReplyService.selectCareReplyCount(board_no);		
		
		
		//좋아요 체크 
		HttpSession session = request.getSession();
		String likeResult = "N";
				
		if (session.getAttribute("loginMember") != null) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("board_no", board_no);
			params.put("user_id", ((Member) session.getAttribute("loginMember")).getUser_id());

			if (careBoardService.selectCareLikeCheck(params) != null) {
						likeResult = "Y";
				}
			}

		if (careBoard != null) {
			mv.addObject("careBoard", careBoard);
			mv.addObject("currentPage", currentPage);
			mv.addObject("replyCount",replyCount);
			mv.addObject("careReply",careReply);
			mv.addObject("likeResult",likeResult);
			

			mv.setViewName("careBoard/careBoardDetailView");
			
		} else {
			mv.addObject("message", "해당게시글이 없습니다");
			mv.setViewName("common/error");
		}
		return mv;
	}

	// 게시글 등록
	@RequestMapping("bwform3.do")
	public String moveCareBoardWriteForm() {
		return "careBoard/careBoardWrite";
	}

	@RequestMapping(value = "cinsert3.do", method = RequestMethod.POST)
	public String careBoardInsert(CareBoard careBoard, Model model, HttpServletRequest request,
			@RequestParam(name = "upfile", required = false) MultipartFile mfile) {
		// 사진파일 저장경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/careBoard_upfiles");

		// 사진파일 이름변경
		if (!mfile.isEmpty()) {
			String image = mfile.getOriginalFilename();

			if (image != null && image.length() > 0) {
				String new_image = FileNameChange.change(image, "yyyyMMddHHmmss");

				// 폴더에 저장 처리함
				try {
					mfile.transferTo(new File(savePath + "\\" + new_image));
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("message", "이미지 저장 실패!");
					return "common/error";
				} // try catch

				// CareBoard 객체에 저장처리
				careBoard.setImage(image);
				careBoard.setNew_image(new_image);
			} // 사진이름변경
		} // 사진파일 있을때

		if (careBoardService.insertBoard(careBoard) > 0) {
			return "redirect:clist3.do";
		} else {
			model.addAttribute("message", "등록실패");
			return "common/error";
		}
	}

	// 수정 페이지 이동 처리용
	@RequestMapping("cupdate3.do")
	public String careBoardUpdatePage(@RequestParam("board_no") int board_no, Model model) {
		CareBoard careBoard = careBoardService.selectCareBoard(board_no);

		if (careBoard != null) {
			model.addAttribute("careBoard", careBoard);

			return "careBoard/careBoardUpdate";
		} else {
			model.addAttribute("message", board_no + "번 글 수정페이지 이동에 실패했습니다.");
			return "common/error";
		}
	}

	// 게시글 수정 처리용
	@RequestMapping(value = "cboardUpdate3.do", method = RequestMethod.POST)
	public String careBoardUpdate(CareBoard careBoard, Model model,
			HttpServletRequest request,			
			@RequestParam(name = "delfile", required = false) String delfile,
			@RequestParam(name = "upfile", required = false) MultipartFile mfile,
			@RequestParam("board_no") int board_no) {
		// 이미지파일 저장경로 지정
		String savePath = request.getSession().
				getServletContext().getRealPath
				("resources/careBoard_upfiles");
		// 이미지파일이 있고 delfile의 값이 널이 아니고 yes 일때
		if (careBoard.getImage() != null 
				&& delfile != null && delfile.equals("yes")) {
	
			new File(savePath + "/" + careBoard.getNew_image()).delete();

			// careBoard의 이미지 파일 삭제
			careBoard.setImage(null);
			careBoard.setNew_image(null);
		}
			// 새로운 첨부이미지가 있을때
			if (!mfile.isEmpty()) {
				// 이전 첨부이미지가 있을시 삭제처리
				if (careBoard.getImage() != null) {
					new File(savePath + "/" + careBoard.getNew_image()).delete();
					// careBoard의 이미지 파일 삭제
					careBoard.setImage(null);
					careBoard.setNew_image(null);
				}

				String image = mfile.getOriginalFilename();
				// 다른 게시글의 첨부파일과 파일명이 중복되어서
				// 덮어쓰기 되는것을 막기 위해, 파일명을 변경해서
				// 폴더에 저장하는 방식을 사용할 수 있음
				// 변경 파일명 : 년월일시분초.확장자
				if (image != null && image.length() > 0) {

					String new_image = FileNameChange.change(image, "yyyyMMddHHmmss");

					// 폴더에 저장처리
					try {
						mfile.transferTo(new File(savePath + "/" + new_image));
					} catch (Exception e) {
						e.printStackTrace();
						model.addAttribute("message", "파일저장 실패!");
						return "common/error";
					} // try catch
					//저장처리
					careBoard.setImage(image);
					careBoard.setNew_image(new_image);
					
				} // 이름변경
			}//신규 첨부파일
			
			// 수정시 조회수 감소 처리
			careBoardService.downUpdateCount(board_no);
			
			if(careBoardService.updateBoard(careBoard) > 0) {
				//수정성공시 상세보기 페이지 이동
				
				model.addAttribute("board_no", careBoard.getBoard_no());
				return "redirect:cdetail3.do";
			}else {
				model.addAttribute("message", careBoard.getBoard_no() + "번 게시글 수정 실패!" );
				return "common/error";
			}
		}
	//CareBoard 삭제처리용
	@RequestMapping("cdelete3.do")
	public String careBoarddelete(CareBoard careBoard, HttpServletRequest request,
			Model model) {
		if(careBoardService.deleteBoard(careBoard) > 0) {
			//삭제 처리되면 첨부파일도 삭제처리
			if(careBoard.getNew_image() != null) {
				new File(request.getSession().getServletContext().
						getRealPath("resources/careBoard_upfiles") + "/"
						+ careBoard.getNew_image()).delete();
			}
			return "redirect:clist3.do?page=1"; //1페이지로 이동처리
		}else {
			model.addAttribute("message",careBoard.getBoard_no() + "번글 삭제 실패!");
			return "common/error";
		}
	}
	//지역검색용
	@RequestMapping(value="careLocation3.do", method = {RequestMethod.POST, RequestMethod.GET })
	public String careBoardLocationSearch(Model model,			
			@RequestParam(value="page", required=false) String page,
			HttpServletRequest request){
		
		String location = request.getParameter("location");
			
		int currentPage = 1;
		if(page != null) {
			currentPage = Integer.parseInt(page);		
		}
		int limit = 10;
		int listCount = 0;
		String url = "careLocation3.do";
		
		Paging paging = new Paging(listCount, currentPage , limit, url);
		
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("location",location);
		
		listCount = careBoardService.selectListLocatonCount(params);
		
		paging.setListCount(listCount);
		paging.calculator();
		
		params.put("paging", paging);
		
		ArrayList<CareBoard> list = careBoardService.selectLocation(params);
		
		if(list != null && list.size() > 0) {
			model.addAttribute("list", list);
			model.addAttribute("location", location);
			model.addAttribute("paging", paging);
			
			
			return "careBoard/careBoardListView";
			
		}else {
			model.addAttribute("message", location +  "에 대한 검색결과 없습니다.");
			return "common/error";
		}
		
	}
	//키워드 검색용
	@RequestMapping("careSearch3.do")
	public String careBoardSerch(Model model,
			@RequestParam("action") String action,
			@RequestParam(value="page" , required=false) String page,			
			HttpServletRequest request) {
		
		
		String keyword = null;
		
		keyword = request.getParameter("keyword");
		
		ArrayList<CareBoard> list = null;
		
		int currentPage = 1;
		
		if(page != null) {
			currentPage = Integer.parseInt(page);			
		}
		int limit = 10;
		
		int listCount = 0;
		
		String url = "careSearch3.do";
		
		Paging paging = new Paging(listCount, currentPage , limit, url);
		
		Map<String,Object> params = new HashMap<String,Object>();		
		params.put("action", action);		
		params.put("keyword", keyword);
		
		listCount = careBoardService.selectListCountSearch(params);
		//총갯수 가져오고
		paging.setListCount(listCount);		
		paging.calculator();		
		params.put("paging", paging);
		
		list = careBoardService.selectSearch(params);
		
		if(list != null && list.size() > 0) {
			model.addAttribute("list", list);
			model.addAttribute("action", action);
			model.addAttribute("keyword", keyword);
			model.addAttribute("paging", paging);
			
			return "careBoard/careBoardListView";
			
		}else {
			return "careBoard/careBoardListView";
		}		
	}
	  //좋아요 증가
	  @RequestMapping("carelikeCountUp.do")
	  public String CareLikeCountInsertMethod(
			  @RequestParam("board_no") int board_no, 
			  @RequestParam("user_id") String user_id,
			  Model model) {	 
		
		  	// 좋아요 클릭시 조회수 감소 처리
			careBoardService.downUpdateCount(board_no);
		  
		  Map<String, Object> params = new HashMap<String, Object>();
		  params.put("board_no", board_no);
		  params.put("user_id", user_id);		  

		  if(careBoardService.insertCareLike(params) > 0) {
			  
			  if(careBoardService.updateCareLikeCount(board_no) > 0) {
			 
				  model.addAttribute("board_no", board_no);
			  return "redirect:cdetail3.do?board_no=" + board_no ;
			 
			  }else {
				  System.out.println("증가 안됨");
			  }
		  }  else {
			  System.out.println("like테이블 insert 안 됨");
		  }
		  return "redirect:cdetail3.do?board_no=" + board_no ;

	  }
	  
	  //좋아요 감소
	  @RequestMapping("carelikeCountDown.do")
	  public String careUnLikeCountInsertMethod(
			  @RequestParam("board_no") int board_no, 
			  @RequestParam("user_id") String user_id,
			  Model model) {
			
		// 좋아요 취소 조회수 감소 처리
		careBoardService.downUpdateCount(board_no);
		  
		  Map<String, Object> params = new HashMap<String, Object>();
		  params.put("board_no", board_no);
		  params.put("user_id", user_id);		  

		  if(careBoardService.deleteCareLike(params) > 0) {
			 
			  if(careBoardService.updateCareLikeCount(board_no) > 0) {
			 
				  model.addAttribute("board_no", board_no);
			  return "redirect:cdetail3.do?board_no=" + board_no ;
			 
			  }else {
				  System.out.println("감소 안됨");
			  }
		  }  else {
			  System.out.println("like테이블 delete 안 됨");
		  }
		  return "redirect:cdetail3.do?board_no=" + board_no ;

	  }
	
	
	

}//Controller
