package com.cono.dogrami.careboard.controller;

import com.cono.dogrami.careboard.model.service.CareBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CareBoardController {
    private static final Logger logger = LoggerFactory.getLogger(CareBoardController.class);

    @Autowired
    private CareBoardService careBoardService;
   
    // Care 게시판
 	// 페이지 내보내기용
// 	public String careBoardPage() {
// 	}
//
// 	// 게시글 상세보기
// 	public String careBoardDetail(
// 			@RequestParam("board_no") int board_no, 
// 			Model model, 
// 			HttpSession session) {
// 	}
//
// 	// 수정 페이지 이동 처리용
// 	public String careBoardUpdatePage(
// 			@RequestParam("board_no") int board_no) {
// 	}
//
// 	// 조회수 TOP5
// 	public String careBoardTop5Method() {
// 	}
//
// 	// 게시판 조회
// 	public String careBoardList(Model model) {
// 	}
//
// 	// 제목으로 조회
// 	public String careBoardTitle(
// 			@RequestParam("keyword") String keyword, 
// 			Model model) {
// 	}
//
// 	// 닉네임으로 조회
// 	public String careBoardNick(
// 			@RequestParam("keyword") String keyword, 
// 			Model model) {
// 	}
//
// 	// 지역으로 조회
// 	public String careBoardLocation(
// 			@RequestParam("keyword") String keyword, 
// 			Model model) {
// 	}
//
// 	// 게시글 수정
// 	public String careBoardUpdate(CareBoard board, Model model) {
// 	}
//
// 	// 게시글 삭제
// 	public String careBoardDelete(
// 			@RequestParam("board_no") int board_no) {
// 	}
//
// 	// 게시글 등록
// 	public String careBoardInsert(CareBoard board, Model model) {
// 	}




}
