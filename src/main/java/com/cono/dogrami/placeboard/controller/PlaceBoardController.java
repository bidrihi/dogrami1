package com.cono.dogrami.placeboard.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.cono.dogrami.careboard.model.vo.CareBoard;
import com.cono.dogrami.hospital.controller.HospitalController;
import com.cono.dogrami.placeboard.model.service.PlaceBoardService;

@Controller
public class PlaceBoardController {
	private static final Logger logger = LoggerFactory.getLogger(PlaceBoardController.class);
	@Autowired //(->Service)
	private PlaceBoardService placeBoardService;

	//Place 게시판
	//페이지 내보내기용
//	public String placeBoardPage() {}
//	
//	//게시글 상세보기
//	public String placeBoardDetail(
//			@RequestParam("board_no") int board_no, 
//			Model model,
//			HttpSession session) {}
//	
//	//수정 페이지 이동 처리용
//	public String placeBoardUpdatePage(
//			@RequestParam("board_no") int board_no) {}
//	
//	//조회수 TOP5
//	public String placeBoardTop5Method() {}
//	
//	//게시판 조회
//	public String placeBoardList(Model model) {}
//	
//	//제목으로 조회
//	public String placeBoardTitle(
//			@RequestParam("keyword") String keyword,
//			Model model) {}
//	
//	//닉네임으로 조회
//	public String placeBoardNick(
//			@RequestParam("keyword") String keyword,
//			Model model) {}
//	
//	//지역으로 조회
//	public String placeBoardLocation(
//			@RequestParam("keyword") String keyword,
//			Model model) {}
//	
//	//게시글 수정
//	public String placeBoardUpdate(CareBoard board, Model model) {}
//	
//	//게시글 삭제
//	public String placeBoardDelete(
//			@RequestParam("board_no") int board_no) {}
//	
//	//게시글 등록
//	public String placeBoardInsert(CareBoard board, Model model) {}
}

