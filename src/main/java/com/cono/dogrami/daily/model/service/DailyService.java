package com.cono.dogrami.daily.model.service;

import java.util.ArrayList;

import com.cono.dogrami.daily.model.vo.Daily;

public interface DailyService {

	ArrayList<Daily> selectList();	//한 페이지에 출력할 게시글 조회용
	Daily selectDailyBoard(int board_no);	//해당 게시글번호에 대한 게시글 상세 조회용
	int updateDailyBoardReadcount(int board_no); //상세보기시에 조회수 1증가 처리용
    int insertDailyBoard(Daily daily);	//원글 등록용
    String selectnickname(int board_no); //닉네임 검색용
    ArrayList<Daily> selectDailyBoardtitle(String keyword); //게시글 제목검색용
    ArrayList<Daily> selectDailyBoardwriter(String keyword); //게시글 작성자검색용
    ArrayList<Daily> selectDailyBoardcontent(String keyword); //게시글 내용검색용
    int updateDailyBoard(Daily daily);	//원글 수정용
    int deleteDailyBoard(Daily daily);	//게시글 삭제용 (원글 삭제시, 관련 댓글과 대댓글 같이 삭제)
    int selectListCount();	//총 게시글 갯수 조회용 (페이지 수 계산용)
    

}
