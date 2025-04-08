package com.cono.dogrami.question.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.question.model.vo.Question;
import com.cono.dogrami.question.model.vo.QuestionLike;

public interface QuestionService {
	
	//한 페이지에 출력할 게시글 조회용
	ArrayList<Question> selectList(Paging page);	
	
	//해당 게시글번호에 대한 게시글 상세 조회용
	Question selectQuestionBoard(int board_no);	
	
	 //상세보기시에 조회수 1증가 처리용
	int updateQuestionBoardReadcount(int board_no);
	
	//원글 등록용
    int insertQuestionBoard(Question question);	
    
    //닉네임 검색용
    String selectnickname(int board_no);
    
    //게시글 검색용
    ArrayList<Question> selectSearch(String action, String keyword, Paging page); 
    
	//원글 수정용
    int updateQuestionBoard(Question question);
    
    //게시글 삭제용
    int deleteQuestionBoard(int board_no);	
    
    //총 게시글 갯수 조회용 (페이지 수 계산용)
    int selectListCount();	
    
    //게시글 검색시 목록 갯수 처리용
    int selectListCountSearch(String keyField ,String keyword);
    
    //좋아요 증가
    int insertQuestionLike(Map<String, Object> params);
    
    //좋아요 감소
    int deleteQuestionLike(Map<String, Object> params);

    //게시판 좋아요 컬럼 숫자증가
	int updateQuestionLikeCount(int board_no);

	//좋아요 체크 여부
	QuestionLike selectQuestionLikeCheck(Map<String, Object> params);


}
