package com.cono.dogrami.diaryreply.controller;

import com.cono.dogrami.diaryreply.model.service.DiaryReplyService;
import com.cono.dogrami.diaryreply.model.vo.DiaryReply;

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
public class DiaryReplyController {
    private static final Logger logger = LoggerFactory.getLogger(DiaryReplyController.class);

    @Autowired
    private DiaryReplyService diaryReplyService;
    
    //댓글 작성
    @RequestMapping(value="diaryreplyinsert.do", method=RequestMethod.POST)
    public String diaryreplyInsertMethod(DiaryReply diaryreply, Model model,
    		@RequestParam(name="board_no") int board_no) {
    	DiaryReply reply = new DiaryReply();
    	
    	reply.setBoard_no(board_no);
    	reply.setRef_content(diaryreply.getRef_content());
    	reply.setRef_writer(diaryreply.getRef_writer());
    	
    	diaryReplyService.insertDiaryReply(reply);
    	
    	return "redirect:diarydetail.do?board_no=" + reply.getBoard_no();
    }
    
    //댓글 수정
    @RequestMapping(value="diaryReplyupdate.do", method=RequestMethod.POST)
    public String diaryreplyupdateMethod(DiaryReply diaryreply) {
    	
    	if(diaryReplyService.updateDiaryReply(diaryreply) > 0) {
    		
    		return  "redirect:diarydetail.do?board_no=" + diaryreply.getBoard_no();
    	} else {
    		return "diary/diaryListView";
    	}	
    }
    
    //댓글 삭제
    @RequestMapping("diaryreplyDelete.do")
    public String diaryreplydeleteMethod(@RequestParam(name="ref_no") int ref_no,
    		@RequestParam(name="board_no") int board_no) {
    	if(diaryReplyService.deleteDiaryReply(ref_no) > 0) {
    		return "redirect:diarydetail.do?board_no=" + board_no;
    	}
    		return "redirect:diarydetail.do?board_no=" + board_no;
    }
    
}
