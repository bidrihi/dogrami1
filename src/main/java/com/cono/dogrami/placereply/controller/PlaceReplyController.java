package com.cono.dogrami.placereply.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.cono.dogrami.hospital.controller.HospitalController;
import com.cono.dogrami.placereply.model.service.PlaceReplyService;
import com.cono.dogrami.placereply.model.vo.PlaceReply;

@Controller
public class PlaceReplyController {
	private static final Logger logger = LoggerFactory.getLogger(PlaceReplyController.class);
	@Autowired
	private PlaceReplyService placeReplyService;
	
	// Place 댓글

	// 댓글 전체 출력용
//	public String placeReplyList(
//			@RequestParam("board_no") int board_no) {
//	}
//
//	// 댓글 수정
//	public String placeReplyUpdate(PlaceReply placeReply, Model model) {
//	}
//
//	// 댓글 삭제
//	public String placeReplyDelete(
//			@RequestParam("rep_no") int rep_no) {
//	}
//
//	// 댓글 작성
//	public String placeReplyInsert(PlaceReply placeReply, Model model) {
//	}
}
