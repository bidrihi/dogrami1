package com.cono.dogrami.dailyreply.controller;

import com.cono.dogrami.dailyreply.model.service.DailyReplyService;
import com.cono.dogrami.dailyreply.model.vo.DailyReply;

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

@Controller
public class DailyReplyController {
    private static final Logger logger = LoggerFactory.getLogger(DailyReplyController.class);

    @Autowired
    private DailyReplyService dailyReplyService;
    
    //댓글 작성
    @RequestMapping(value="dailyreplyinsert.do", method=RequestMethod.POST)
    public String dailyreplyInsertMethod(DailyReply dailyreply, Model model,
    		@RequestParam(name="board_no") int board_no) {
    	DailyReply reply = new DailyReply();
    	
    	reply.setBoard_no(board_no);
    	reply.setRef_content(dailyreply.getRef_content());
    	reply.setRef_writer(dailyreply.getRef_writer());
    	
    	dailyReplyService.insertDailyReply(reply);
    	
    	return "redirect:dailydetail.do?board_no=" + reply.getBoard_no();
    }
    
    //댓글 수정
    @RequestMapping(value="dailyReplyupdate.do", method=RequestMethod.POST)
    public String dailyreplyupdateMethod(DailyReply dailyreply) {
    	
    	if(dailyReplyService.updateDailyReply(dailyreply) > 0) {
    		
    		return  "redirect:dailydetail.do?board_no=" + dailyreply.getBoard_no();
    	} else {
    		return "daily/dailyListView";
    	}	
    }
    
    //댓글 삭제
    @RequestMapping("dailyreplyDelete.do")
    public String dailyreplydeleteMethod(@RequestParam(name="ref_no") int ref_no,
    		@RequestParam(name="board_no") int board_no) {
    	if(dailyReplyService.deleteDailyReply(ref_no) > 0) {
    		return "redirect:dailydetail.do?board_no=" + board_no;
    	}
    		return "redirect:dailydetail.do?board_no=" + board_no;
    }
    
}
