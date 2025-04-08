package com.cono.dogrami.placeboard.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cono.dogrami.careboard.model.vo.CareBoard;
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

import com.cono.dogrami.placeboard.model.vo.PlaceBoard;
import com.cono.dogrami.placereply.model.vo.PlaceReply;
import com.cono.dogrami.common.FileNameChange;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.member.model.vo.Member;
import com.cono.dogrami.placeboard.model.service.PlaceBoardService;
import com.cono.dogrami.placereply.model.service.PlaceReplyService;

@Controller
public class PlaceBoardController {

	@Autowired
	private PlaceBoardService placeBoardService;

	@Autowired
	private PlaceReplyService placeReplyService;

	//메인 최신 게시글 보기
	@RequestMapping(value = "placenew5.do", method = RequestMethod.POST)
	@ResponseBody
	public String placeNewTop5Method() throws UnsupportedEncodingException {
		ArrayList<PlaceBoard> list = placeBoardService.selectNewTop5();

		JSONObject sendJson = new JSONObject();
		JSONArray jarr = new JSONArray();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		for (PlaceBoard placeBoard : list) {
			JSONObject job = new JSONObject();

			job.put("board_no", placeBoard.getBoard_no());
			job.put("board_title", URLEncoder.encode(placeBoard.getBoard_title(), "utf-8"));
			job.put("category", URLEncoder.encode(placeBoard.getCategory(), "utf-8"));
			job.put("location", URLEncoder.encode(placeBoard.getLocation(), "utf-8"));
			job.put("board_date", sdf.format(placeBoard.getBoard_date()));

			jarr.add(job);
		}

		sendJson.put("list", jarr);

		return sendJson.toJSONString();
	}

	// Place 게시판
	// place 게시판
	// 게시글 페이지 단위로 목록보기 요청 처리용
	@RequestMapping("plist3.do")
	public ModelAndView placeBoardList(@RequestParam(name = "page", required = false) String page, ModelAndView mv) {
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		int limit = 10; // 한페이지에 10개씩 출력
		int listCount = placeBoardService.selectListCount(); // 총글갯수 조회
		String url = "clist3.do";
		Paging paging = new Paging(listCount, currentPage, limit, url);
		paging.calculator();

		ArrayList<PlaceBoard> list = placeBoardService.selectList(paging);

		if (list != null && list.size() >= 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.setViewName("placeBoard/placeBoardListView");
		} else {
			mv.addObject("message", "error");
			mv.setViewName("error/common");
		}
		return mv;
	}

	// 게시글 상세보기
	@RequestMapping("pdetail3.do")
	public ModelAndView placeBoardDetail(@RequestParam("board_no") int board_no,
			@RequestParam(name = "page", required = false) String page, 
			ModelAndView mv, HttpServletRequest request) {
		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}

		// 조회수 1증가 처리(들어갈시)
		placeBoardService.updateCount(board_no);

		// 해당 게시글 조회
		PlaceBoard placeBoard = placeBoardService.selectPlaceBoard(board_no);

		// 해당 게시글 댓글 조회
		ArrayList<PlaceReply> placeReply = placeReplyService.selectList(board_no);
		
		//댓글 갯수
		int replyCount = placeReplyService.selectPlaceReplyCount(board_no);
		
		//좋아요 체크 
				HttpSession session = request.getSession();
				String likeResult = "N";
						
				if (session.getAttribute("loginMember") != null) {
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("board_no", board_no);
					params.put("user_id", ((Member) session.getAttribute("loginMember")).getUser_id());

					if (placeBoardService.selectPlaceLikeCheck(params) != null) {
								likeResult = "Y";
						}
					}

				if (placeBoard != null) {
					mv.addObject("placeBoard", placeBoard);
					mv.addObject("currentPage", currentPage);
					mv.addObject("replyCount",replyCount);
					mv.addObject("placeReply",placeReply);
					mv.addObject("likeResult",likeResult);
		
					mv.setViewName("placeBoard/placeBoardDetailView");
		
				} else {
					mv.addObject("message", "해당게시글이 없습니다");
					mv.setViewName("common/error");
				}
				return mv;
			}

	// 게시글 등록
	@RequestMapping("pwform3.do")
	public String moveplaceBoardWriteForm() {
		return "placeBoard/placeBoardWrite";
	}

	@RequestMapping(value = "pinsert3.do", method = RequestMethod.POST)
	public String placeBoardInsert(PlaceBoard placeBoard, Model model, HttpServletRequest request,
			@RequestParam(name = "upfile", required = false) MultipartFile mfile) {
		// 사진파일 저장경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/placeBoard_upfiles");

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

				// placeBoard 객체에 저장처리
				placeBoard.setImage(image);
				placeBoard.setNew_image(new_image);
			} // 사진이름변경
		} // 사진파일 있을때

		if (placeBoardService.insertBoard(placeBoard) > 0) {
			return "redirect:plist3.do";
		} else {
			model.addAttribute("message", "등록실패");
			return "common/error";
		}
	}

	// 수정 페이지 이동 처리용
	@RequestMapping("pupdate3.do")
	public String placeBoardUpdatePage(@RequestParam("board_no") int board_no, Model model) {
		PlaceBoard placeBoard = placeBoardService.selectPlaceBoard(board_no);

		if (placeBoard != null) {
			model.addAttribute("placeBoard", placeBoard);

			return "placeBoard/placeBoardUpdate";
		} else {
			model.addAttribute("message", board_no + "번 글 수정페이지 이동에 실패했습니다.");
			return "common/error";
		}
	}

	// 게시글 수정 처리용
	@RequestMapping(value = "pboardUpdate3.do", method = RequestMethod.POST)
	public String placeBoardUpdate(PlaceBoard placeBoard, Model model, HttpServletRequest request,
			@RequestParam(name = "delfile", required = false) String delfile,
			@RequestParam(name = "upfile", required = false) MultipartFile mfile,
			@RequestParam("board_no") int board_no) {
		// 이미지파일 저장경로 지정
		String savePath = request.getSession().getServletContext().getRealPath("resources/placeBoard_upfiles");
		// 이미지파일이 있고 delfile의 값이 널이 아니고 yes 일때
		if (placeBoard.getImage() != null && delfile != null && delfile.equals("yes")) {

			new File(savePath + "/" + placeBoard.getNew_image()).delete();

			// placeBoard의 이미지 파일 삭제
			placeBoard.setImage(null);
			placeBoard.setNew_image(null);
		}
		// 새로운 첨부이미지가 있을때
		if (!mfile.isEmpty()) {
			// 이전 첨부이미지가 있을시 삭제처리
			if (placeBoard.getImage() != null) {
				new File(savePath + "/" + placeBoard.getNew_image()).delete();
				// placeBoard의 이미지 파일 삭제
				placeBoard.setImage(null);
				placeBoard.setNew_image(null);
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
					// 저장처리
				placeBoard.setImage(image);
				placeBoard.setNew_image(new_image);

			} // 이름변경
		} // 신규 첨부파일
		
			//수정시 조회수 감소처리
		  	placeBoardService.downUpdateCount(board_no);
		  	
		if (placeBoardService.updateBoard(placeBoard) > 0) {
			// 수정성공시 상세보기 페이지 이동

			model.addAttribute("board_no", placeBoard.getBoard_no());
			return "redirect:pdetail3.do";
		} else {
			model.addAttribute("message", placeBoard.getBoard_no() + "번 게시글 수정 실패!");
			return "common/error";
		}
	}

	// placeBoard 삭제처리용
	@RequestMapping("pdelete3.do")
	public String placeBoarddelete(PlaceBoard placeBoard, HttpServletRequest request, Model model) {
		if (placeBoardService.deleteBoard(placeBoard) > 0) {
			// 삭제 처리되면 첨부파일도 삭제처리
			if (placeBoard.getNew_image() != null) {
				new File(request.getSession().getServletContext().getRealPath("resources/placeBoard_upfiles") + "/"
						+ placeBoard.getNew_image()).delete();
			}
			return "redirect:plist3.do?page=1"; // 1페이지로 이동처리
		} else {
			model.addAttribute("message", placeBoard.getBoard_no() + "번글 삭제 실패!");
			return "common/error";
		}
	}

	// 지역검색용
	@RequestMapping(value = "placeLocation3.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String placeBoardLocationSearch(Model model, @RequestParam(value = "page", required = false) String page,
			HttpServletRequest request) {

		String location = request.getParameter("location");

		int currentPage = 1;
		if (page != null) {
			currentPage = Integer.parseInt(page);
		}
		int limit = 10;
		int listCount = 0;
		String url = "placeLocation3.do";

		Paging paging = new Paging(listCount, currentPage, limit, url);

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("location", location);

		listCount = placeBoardService.selectListLocatonCount(params);

		paging.setListCount(listCount);
		paging.calculator();

		params.put("paging", paging);

		ArrayList<PlaceBoard> list = placeBoardService.selectLocation(params);

		if (list != null && list.size() > 0) {
			model.addAttribute("list", list);
			model.addAttribute("location", location);
			model.addAttribute("paging", paging);

			return "placeBoard/placeBoardListView";

		} else {
			model.addAttribute("message", location + "에 대한 검색결과 없습니다.");
			return "common/error";
		}

	}

	// 키워드 검색용
	@RequestMapping("placeSearch3.do")
	public String placeBoardSerch(Model model, @RequestParam("action") String action,
			@RequestParam(value = "page", required = false) String page, HttpServletRequest request) {

		String keyword = null;

		keyword = request.getParameter("keyword");

		ArrayList<PlaceBoard> list = null;

		int currentPage = 1;

		if (page != null) {
			currentPage = Integer.parseInt(page);
		}
		int limit = 10;

		int listCount = 0;

		String url = "placeSearch3.do";

		Paging paging = new Paging(listCount, currentPage, limit, url);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("action", action);
		params.put("keyword", keyword);

		listCount = placeBoardService.selectListCountSearch(params);
		// 총갯수 가져오고
		paging.setListCount(listCount);
		paging.calculator();
		params.put("paging", paging);

		list = placeBoardService.selectSearch(params);

		if (list != null && list.size() > 0) {
			model.addAttribute("list", list);
			model.addAttribute("action", action);
			model.addAttribute("keyword", keyword);
			model.addAttribute("paging", paging);

			return "placeBoard/placeBoardListView";

		} else {
			return "placeBoard/placeBoardListView";
		}
	}
	
	//좋아요 증가
	  @RequestMapping("placelikeCountUp.do")
	  public String placeLikeCountInsertMethod(
			  @RequestParam("board_no") int board_no, 
			  @RequestParam("user_id") String user_id,
			  Model model) {	
		  
		  //좋아요 클릭시 조회수 감소 처리
		  placeBoardService.downUpdateCount(board_no);
		  
		  Map<String, Object> params = new HashMap<String, Object>();
		  params.put("board_no", board_no);
		  params.put("user_id", user_id);		  

		  if(placeBoardService.insertPlaceLike(params) > 0) {
			  
			  if(placeBoardService.updatePlaceLikeCount(board_no) > 0) {
			 
				  model.addAttribute("board_no", board_no);
			  return "redirect:pdetail3.do?board_no=" + board_no ;
			 
			  }else {
				  System.out.println("증가 안됨");
			  }
		  }  else {
			  System.out.println("like테이블 insert 안 됨");
		  }
		  return "redirect:pdetail3.do?board_no=" + board_no ;

	  }
	  
	  //좋아요 감소
	  @RequestMapping("placelikeCountDown.do")
	  public String placeUnLikeCountInsertMethod(
			  @RequestParam("board_no") int board_no, 
			  @RequestParam("user_id") String user_id,
			  Model model) {
		
		  //좋아요 취소시 조회수 감소 처리
		  placeBoardService.downUpdateCount(board_no);
		  
		  Map<String, Object> params = new HashMap<String, Object>();
		  params.put("board_no", board_no);
		  params.put("user_id", user_id);		  

		  if(placeBoardService.deletePlaceLike(params) > 0) {
			 
			  if(placeBoardService.updatePlaceLikeCount(board_no) > 0) {
			 
				  model.addAttribute("board_no", board_no);
			  return "redirect:pdetail3.do?board_no=" + board_no ;
			 
			  }else {
				  System.out.println("감소 안됨");
			  }
		  }  else {
			  System.out.println("like테이블 delete 안 됨");
		  }
		  return "redirect:pdetail3.do?board_no=" + board_no ;

	  }

}// Controller
