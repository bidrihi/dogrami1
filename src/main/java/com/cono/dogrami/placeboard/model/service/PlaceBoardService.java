package com.cono.dogrami.placeboard.model.service;

import java.util.ArrayList;
import java.util.Map;


import com.cono.dogrami.common.Paging;
import com.cono.dogrami.placeboard.model.vo.PlaceBoard;
import com.cono.dogrami.placeboard.model.vo.PlaceLike;


public interface PlaceBoardService {

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
		ArrayList<PlaceBoard> selectSearch(Map<String, Object> params);
		
		//전체게시글 리스트
		ArrayList<PlaceBoard> selectList(Paging page);

		//지역으로 검색
		ArrayList<PlaceBoard> selectLocation(Map<String, Object> params);
		
		//게시글 작성용
		int insertBoard(PlaceBoard placeBoard);
		
		//게시글 수정용
		int updateBoard(PlaceBoard placeBoard);
		
		//게시글 삭제
		int deleteBoard(PlaceBoard placeBoard);
		
		//게시글 삭제
		PlaceBoard selectPlaceBoard(int board_no);
		
		//좋아요 증가
	    int insertPlaceLike(Map<String, Object> params);
	    
	    //좋아요 감소
	    int deletePlaceLike(Map<String, Object> params);
	    
	    //게시글 좋아요 컬럼 숫자증가
	  	int updatePlaceLikeCount(int board_no);

		PlaceLike selectPlaceLikeCheck(Map<String, Object> params);

	ArrayList<PlaceBoard> selectNewTop5();
}
