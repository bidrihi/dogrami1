package com.cono.dogrami.question.model.service;

import com.cono.dogrami.question.model.dao.QuestionDao;
import com.cono.dogrami.question.model.vo.QuestionLike;
import com.cono.dogrami.question.model.vo.Question;
import com.cono.dogrami.common.Paging;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
    
	@Autowired
    private QuestionDao questionDao;
	
	//게시글 리스트
	@Override
	public ArrayList<Question> selectList(Paging page) {
		return questionDao.selectList(page);
	}

	//게시글 검색
	@Override
	public Question selectQuestionBoard(int board_no) {
		return questionDao.selectQuestionBoard(board_no);
	}
	
	//게시글 조회수 증가
	@Override
	public int updateQuestionBoardReadcount(int board_no) {
		return questionDao.updateQuestionBoardReadcount(board_no);
	}
	
	//조인해서 닉네임 가져오기
	@Override
	public String selectnickname(int board_no) {
		return questionDao.selectnickname(board_no);
	}
	
	//게시글 목록 검색
	@Override
	public ArrayList<Question> selectSearch(String action, String keyword, Paging page) {
		return questionDao.selectSearch(action, keyword, page);
	}
	
	//게시글 검색시 목록 갯수
    @Override
    public int selectListCount() {
        return questionDao.selectListCount();
    }

    //게시글 삭제
	@Override
	public int deleteQuestionBoard(int board_no) {
		return questionDao.deleteQuestionBoard(board_no);
	}

    //게시글 작성
    @Override
    public int insertQuestionBoard(Question question) {
        return questionDao.insertQuestionBoard(question);
    }

    //게시글 수정
    @Override
    public int updateQuestionBoard(Question question) {
        return questionDao.updateQuestionBoard(question);
    }
    
    //게시글 검색
    @Override
	public int selectListCountSearch(String keyField, String keyword) {
		return questionDao.selectListCountSearch(keyField, keyword);
	}

    //좋아요 증가
    @Override
    public int insertQuestionLike(Map<String, Object> params) {
    	return questionDao.insertQuestionLike(params);
    }

    //좋아요 감소
    @Override
    public int deleteQuestionLike(Map<String, Object> params) {
    	return questionDao.deleteQuestionLike(params);
    }
    
    //게시판 좋아요 컬럼 숫자증가
	@Override
	public int updateQuestionLikeCount(int board_no) {
		return questionDao.updateQuestionLikeCount(board_no);
	}

	@Override
	public QuestionLike selectQuestionLikeCheck(Map<String, Object> params) {
		return questionDao.selectQuestionLikeCheck(params);
	}











}
