package com.cono.dogrami.carereply.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cono.dogrami.careboard.model.service.CareBoardService;
import com.cono.dogrami.careboard.model.vo.CareBoard;
import com.cono.dogrami.carereply.model.service.CareReplyService;
import com.cono.dogrami.carereply.model.vo.CareReply;

@Controller
public class CareReplyController {

    @Autowired
    private CareReplyService careReplyService;

    @Autowired
	private CareBoardService careBoardService;
    
    // Care 댓글등록  
    @RequestMapping(value="crepinsert3.do", method= {RequestMethod.POST, RequestMethod.GET})
    public String careReplyInsert(CareReply careReply, Model model,
    		@RequestParam("page") int page) {
    		 	
    	careBoardService.selectListCount();
    	
    	if(careReplyService.insertReply(careReply) > 0) {
    					
    		return "redirect:cdetail3.do?board_no=" 
    	+ careReply.getBoard_no() + "&page=" + page;
    	}else {
    		model.addAttribute("message","댓글등록 실패!");
    		return "common/error";
    	}	
    }

 	// 댓글 수정 페이지 이동처리
    @RequestMapping(value="creplyUpdate3.do", method= {RequestMethod.POST, RequestMethod.GET})
 	public String CareReplyUpdate(CareReply careReply, Model model,
 			@RequestParam("board_no") int board_no,
 			@RequestParam("ref_no") int ref_no,
 			@RequestParam("page") int page) {
    	if(careReplyService.updateReply(careReply) > 0) {
    			
    		
    		return "redirect:cdetail3.do?board_no="
    		+ careReply.getBoard_no() + "&page=" + page;
    	}else {
    		model.addAttribute("message", "댓글 수정 실패!");
    		return "common/error";
    	}
 	}

 	// 댓글 삭제
    @RequestMapping(value="creplyDelete3.do", method={RequestMethod.POST, RequestMethod.GET} )
 	public String CareReplyDelete(Model model,
 			CareReply careReply,
 			@RequestParam("page") int page,
 			@RequestParam("board_no") int board_no,
 			@RequestParam("ref_no") int ref_no) {
    		
    	if(careReplyService.deleteReply(ref_no) > 0) {
    		
    		
    		return "redirect:cdetail3.do?board_no=" 
    		    	+ board_no + "&page=" + page;
    	}else {
    		model.addAttribute("message", "댓글 삭제 실패!");
    		return "common/error";
    	}
 	}

}


