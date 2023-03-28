package com.cono.dogrami.daily.model.service;

import com.cono.dogrami.daily.model.vo.Daily;

public interface DailyService {
	
	int selectListCount();	//총 게시글 갯수 조회용 (페이지 수 계산용)
	Daily selectDailyBoard(int board_no);	//해당 게시글번호에 대한 게시글 상세 조회용
	int updateDailyBoardReadcount(int board_no);	//상세보기시에 조회수 1증가 처리용
	int insertDailyBoard(Daily daily);	//원글 등록용
	int updateDailyBoard(Daily daily);	//원글 수정용
	int deleteDailyBoard(Daily daily);	//게시글 삭제용 (원글 삭제시, 관련 댓글과 대댓글 같이 삭제)
	
}
