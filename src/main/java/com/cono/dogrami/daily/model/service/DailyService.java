package com.cono.dogrami.daily.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.daily.model.vo.Daily;
import com.cono.dogrami.daily.model.vo.DailyLike;

public interface DailyService {
	
	//한 페이지에 출력할 게시글 조회용
	ArrayList<Daily> selectList(Paging page);	
	
	//해당 게시글번호에 대한 게시글 상세 조회용
	Daily selectDailyBoard(int board_no);	
	
	 //상세보기시에 조회수 1증가 처리용
	int updateDailyBoardReadcount(int board_no);
	
	//원글 등록용
    int insertDailyBoard(Daily daily);	
    
    //닉네임 검색용
    String selectnickname(int board_no);
    
    //게시글 검색용
    ArrayList<Daily> selectSearch(Map<String, Object> params); 
    
	//원글 수정용
    int updateDailyBoard(Daily daily);
    
    //게시글 삭제용
    int deleteDailyBoard(int board_no);	
    
    //총 게시글 갯수 조회용 (페이지 수 계산용)
    int selectListCount();	
    
    //게시글 검색시 목록 갯수 처리용
    int selectListCountSearch(Map<String, Object> params);
    
    //좋아요 증가
    int insertDailyLike(Map<String, Object> params);
    
    //좋아요 감소
    int deleteDailyLike(Map<String, Object> params);

    //게시판 좋아요 컬럼 숫자증가
	int updateDailyLikeCount(int board_no);

	//좋아요 체크 여부
	DailyLike selectDailyLikeCheck(Map<String, Object> params);


}
