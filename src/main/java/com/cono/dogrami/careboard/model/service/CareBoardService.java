package com.cono.dogrami.careboard.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.careboard.model.vo.CareBoard;
import com.cono.dogrami.careboard.model.vo.CareLike;
import com.cono.dogrami.common.Paging;


public interface CareBoardService {
	
	//총 게시글 갯수 조회용 (페이지 수 계산용)
	int selectListCount();	
	
	//제목,작성자,내용검색 게시글 갯수
	int selectListCountSearch(Map<String,Object> params);	
	
	//조회수증가  (페이지 수 계산용)
	int updateCount(int board_no);   
	
	//조회수 감소
	int downUpdateCount(int board_no);
	
	//지역검색 게시글 갯수
	int selectListLocatonCount(Map<String, Object> params);
	
	//키워드검색 리스트
	ArrayList<CareBoard> selectSearch(Map<String, Object> params);
	
	//전체게시글 리스트
	ArrayList<CareBoard> selectList(Paging page);

	//지역으로 검색
	ArrayList<CareBoard> selectLocation(Map<String, Object> params);
	
	//게시글 작성용
	int insertBoard(CareBoard careBoard);
	
	//게시글 수정용
	int updateBoard(CareBoard careBoard);
	
	//게시글 삭제
	int deleteBoard(CareBoard careBoard);
	
	//게시글 삭제
	CareBoard selectCareBoard(int board_no);
	
	//좋아요 증가
    int insertCareLike(Map<String, Object> params);
    
    //좋아요 감소
    int deleteCareLike(Map<String, Object> params);
    
    //게시글 좋아요 컬럼 숫자증가
  	int updateCareLikeCount(int board_no);

	CareLike selectCareLikeCheck(Map<String, Object> params);

	ArrayList<CareBoard> selectNewTop5();
}
