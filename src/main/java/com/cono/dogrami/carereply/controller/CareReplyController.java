package com.cono.dogrami.carereply.controller;

import com.cono.dogrami.carereply.model.service.CareReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CareReplyController {
    private static final Logger logger = LoggerFactory.getLogger(CareReplyController.class);

    @Autowired
    private CareReplyService careReplyService;
    
    // Care 댓글

 	// 댓글 전체 출력용
// 	public String CareReplyList(
// 			@RequestParam("board_no") int board_no) {
// 	}
//
// 	// 댓글 수정
// 	public String CareReplyUpdate(CareReply careReply, Model model) {
// 	}
//
// 	// 댓글 삭제
// 	public String CareReplyDelete(
// 			@RequestParam("rep_no") int rep_no) {
// 	}
//
// 	// 댓글 등록
// 	public String CareReplyInsert(CareReply careReply, Model model) {
// 	}
 }


