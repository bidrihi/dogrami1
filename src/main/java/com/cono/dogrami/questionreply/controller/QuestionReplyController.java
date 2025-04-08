package com.cono.dogrami.questionreply.controller;

import com.cono.dogrami.questionreply.model.service.QuestionReplyService;
import com.cono.dogrami.questionreply.model.vo.QuestionReply;

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
public class QuestionReplyController {
    private static final Logger logger = LoggerFactory.getLogger(QuestionReplyController.class);

    @Autowired
    private QuestionReplyService questionReplyService;
    
    //댓글 작성
    @RequestMapping(value="questionreplyinsert.do", method=RequestMethod.POST)
    public String questionreplyInsertMethod(QuestionReply questionreply, Model model,
    		@RequestParam(name="board_no") int board_no) {
    	QuestionReply reply = new QuestionReply();
    	
    	reply.setBoard_no(board_no);
    	reply.setRef_content(questionreply.getRef_content());
    	reply.setRef_writer(questionreply.getRef_writer());
    	
    	questionReplyService.insertQuestionReply(reply);
    	
    	return "redirect:questiondetail.do?board_no=" + reply.getBoard_no();
    }
    
    //댓글 수정
    @RequestMapping(value="questionReplyupdate.do", method=RequestMethod.POST)
    public String questionreplyupdateMethod(QuestionReply questionreply) {
    	
    	if(questionReplyService.updateQuestionReply(questionreply) > 0) {
    		
    		return  "redirect:questiondetail.do?board_no=" + questionreply.getBoard_no();
    	} else {
    		return "question/questionListView";
    	}	
    }
    
    //댓글 삭제
    @RequestMapping("questionreplyDelete.do")
    public String questionreplydeleteMethod(@RequestParam(name="ref_no") int ref_no,
    		@RequestParam(name="board_no") int board_no) {
    	if(questionReplyService.deleteQuestionReply(ref_no) > 0) {
    		return "redirect:questiondetail.do?board_no=" + board_no;
    	}
    		return "redirect:questiondetail.do?board_no=" + board_no;
    }
    
}
