package com.cono.dogrami.infosharereply.controller;

import com.cono.dogrami.infosharereply.model.service.InfoshareReplyService;
import com.cono.dogrami.infosharereply.model.vo.InfoshareReply;

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
public class InfoshareReplyController {
    private static final Logger logger = LoggerFactory.getLogger(InfoshareReplyController.class);

    @Autowired
    private InfoshareReplyService infoshareReplyService;
    
    //댓글 작성
    @RequestMapping(value="infosharereplyinsert.do", method=RequestMethod.POST)
    public String infosharereplyInsertMethod(InfoshareReply infosharereply, Model model,
    		@RequestParam(name="board_no") int board_no) {
    	InfoshareReply reply = new InfoshareReply();
    	
    	reply.setBoard_no(board_no);
    	reply.setRef_content(infosharereply.getRef_content());
    	reply.setRef_writer(infosharereply.getRef_writer());
    	
    	infoshareReplyService.insertInfoshareReply(reply);
    	
    	return "redirect:infosharedetail.do?board_no=" + reply.getBoard_no();
    }
    
    //댓글 수정
    @RequestMapping(value="infoshareReplyupdate.do", method=RequestMethod.POST)
    public String infosharereplyupdateMethod(InfoshareReply infosharereply) {
    	
    	if(infoshareReplyService.updateInfoshareReply(infosharereply) > 0) {
    		
    		return  "redirect:infosharedetail.do?board_no=" + infosharereply.getBoard_no();
    	} else {
    		return "infoshare/infoshareListView";
    	}	
    }
    
    //댓글 삭제
    @RequestMapping("infosharereplyDelete.do")
    public String infosharereplydeleteMethod(@RequestParam(name="ref_no") int ref_no,
    		@RequestParam(name="board_no") int board_no) {
    	if(infoshareReplyService.deleteInfoshareReply(ref_no) > 0) {
    		return "redirect:infosharedetail.do?board_no=" + board_no;
    	}
    		return "redirect:infosharedetail.do?board_no=" + board_no;
    }
    
}
