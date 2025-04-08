package com.cono.dogrami.placereply.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cono.dogrami.placeboard.model.service.PlaceBoardService;
import com.cono.dogrami.placereply.model.service.PlaceReplyService;
import com.cono.dogrami.placereply.model.vo.PlaceReply;

@Controller
public class PlaceReplyController {
	private static final Logger logger = LoggerFactory.getLogger(PlaceReplyController.class);
	
	// Place 댓글
	@Autowired
    private PlaceReplyService placereplyService;

    @Autowired
	private PlaceBoardService pareBoardService;
    
    // Care 댓글등록  
    @RequestMapping(value="prepinsert3.do", method= {RequestMethod.POST, RequestMethod.GET})
    public String placereplyInsert(PlaceReply placereply, Model model,
    		@RequestParam("page") int page) {
    		 	
    	pareBoardService.selectListCount();
    	
    	if(placereplyService.insertReply(placereply) > 0) {
    					
    		return "redirect:pdetail3.do?board_no=" 
    	+ placereply.getBoard_no() + "&page=" + page;
    	}else {
    		model.addAttribute("message","댓글등록 실패!");
    		return "common/error";
    	}	
    }

 	// 댓글 수정 페이지 이동처리
    @RequestMapping(value="preplyUpdate3.do", method= {RequestMethod.POST, RequestMethod.GET})
 	public String placereplyUpdate(PlaceReply placereply, Model model,
 			@RequestParam("board_no") int board_no,
 			@RequestParam("ref_no") int ref_no,
 			@RequestParam("page") int page) {
    	if(placereplyService.updateReply(placereply) > 0) {
    			
    		
    		return "redirect:pdetail3.do?board_no="
    		+ placereply.getBoard_no() + "&page=" + page;
    	}else {
    		model.addAttribute("message", "댓글 수정 실패!");
    		return "common/error";
    	}
 	}

 	// 댓글 삭제
    @RequestMapping(value="preplyDelete3.do", method={RequestMethod.POST, RequestMethod.GET} )
 	public String placereplyDelete(Model model,
 			PlaceReply placereply,
 			@RequestParam("page") int page,
 			@RequestParam("board_no") int board_no,
 			@RequestParam("ref_no") int ref_no) {
    		
    	if(placereplyService.deleteReply(ref_no) > 0) {
    		
    		
    		return "redirect:pdetail3.do?board_no=" 
    		    	+ board_no + "&page=" + page;
    	}else {
    		model.addAttribute("message", "댓글 삭제 실패!");
    		return "common/error";
    	}
 	}

}

