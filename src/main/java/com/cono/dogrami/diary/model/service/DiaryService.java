package com.cono.dogrami.diary.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.diary.model.vo.Diary;
import com.cono.dogrami.diary.model.vo.DiaryLike;

public interface DiaryService {
	
	//한 페이지에 출력할 게시글 조회용(비회원용)
	ArrayList<Diary> selectList(Paging page);	
	
	//한 페이지에 출력할 게시글 조회용(회원용)
	ArrayList<Diary> selectListUser(Map<String, Object> params);
	
	//한 페이지에 출력할 게시글 조회용(관리자용)
	ArrayList<Diary> selectListAdmin(Paging page);
	
	//해당 게시글번호에 대한 게시글 상세 조회용
	Diary selectDiaryBoard(int board_no);	
	
	 //상세보기시에 조회수 1증가 처리용
	int updateDiaryBoardReadcount(int board_no);
	
	//원글 등록용
    int insertDiaryBoard(Diary diary);	
    
    //닉네임 검색용
    String selectnickname(int board_no);
    
    //게시글 검색용(비회원)
    ArrayList<Diary> selectSearch(Map<String, Object> params); 
    
    //게시글 검색용(회원)
    ArrayList<Diary> selectSearchUser(Map<String, Object> params); 
    
    //게시글 검색용(관리자)
    ArrayList<Diary> selectSearchAdmin(Map<String, Object> params); 
    
	//원글 수정용
    int updateDiaryBoard(Diary diary);
    
    //게시글 삭제용
    int deleteDiaryBoard(int board_no);	
    
    //총 게시글 갯수 조회용 (페이지 수 계산용, 비회원용)
    int selectListCount();
    
    //총 게시글 갯수 조회용 (페이지 수 계산용, 회원용)
    int selectListCountUser(String user_id);
    
    //총 게시글 갯수 조회용 (페이지 수 계산용, 관리자용)
    int selectListCountAdmin();
    
    
    //게시글 검색시 목록 갯수 처리용(비회원)
    int selectListCountSearch(Map<String, Object> params);
    
    //게시글 검색시 목록 갯수 처리용(회원)
    int selectListCountSearchUser(Map<String, Object> params);
    
    //게시글 검색시 목록 갯수 처리용(관리자)
    int selectListCountSearchAdmin(Map<String, Object> params);
    
    //좋아요 증가
    int insertDiaryLike(Map<String, Object> params);
    
    //좋아요 감소
    int deleteDiaryLike(Map<String, Object> params);

    //게시판 좋아요 컬럼 숫자증가
	int updateDiaryLikeCount(int board_no);

	//좋아요 체크 여부
	DiaryLike selectDiaryLikeCheck(Map<String, Object> params);


}
