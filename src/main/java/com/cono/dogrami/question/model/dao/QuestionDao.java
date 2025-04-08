package com.cono.dogrami.question.model.dao;

import com.cono.dogrami.question.model.vo.Question;
import com.cono.dogrami.question.model.vo.QuestionLike;
import com.cono.dogrami.common.Paging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("questionDao")
public class QuestionDao {

    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<Question> selectList(Paging page) {
	List<Question> list = session.selectList("questionboardMapper.selectList", page);
		return (ArrayList<Question>)list;
	}
    
	public Question selectQuestionBoard(int board_no) {
		return session.selectOne("questionboardMapper.selectQuestionBoard",board_no);
	}
	
	
	public int updateQuestionBoardReadcount(int board_no) {
		return session.update("questionboardMapper.updateQuestionBoardReadcount",board_no);
	}

	public String selectnickname(int board_no) {
		return session.selectOne("questionboardMapper.selectnickname",board_no);
	}
	
	public ArrayList<Question> selectSearch(String action, String keyword, Paging page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("action", action);
		params.put("keyword", keyword);
		params.put("page", page);
		List<Question> list = session.selectList("questionboardMapper.selectSearch", params);
		return (ArrayList<Question>)list;
	}
	
    public int selectListCount() {
        return session.selectOne("questionboardMapper.selectListCount");
    }


    public int insertQuestionBoard(Question question) {
        return session.insert("questionboardMapper.insertQuestionBoard",question);
    }


    public int updateQuestionBoard(Question question) {
        return session.update("questionboardMapper.updateQuestionBoard",question);
    }


    public int deleteQuestionBoard(int board_no) {
        return session.delete("questionboardMapper.deleteQuestionBoard",board_no);
    }

    public int selectListCountSearch(String keyField, String keyword) {
    	Map<String, Object> params = new HashMap<String, Object>();
		params.put("keyField", keyField);
		params.put("keyword", keyword);
		List<Question> list = session.selectList("questionboardMapper.selectListCountSearch", params);
		return list.size();
    }
    
    //좋아요 증가
    public int insertQuestionLike(Map<String, Object> params) {
    	return session.insert("questionboardMapper.insertQuestionLike", params);
    }

    //좋아요 감소
    public int deleteQuestionLike(Map<String, Object> params) {
    	return session.delete("questionboardMapper.deleteQuestionLike", params);
    }

    //게시판 좋아요 컬럼 숫자증가
	public int updateQuestionLikeCount(int board_no) {
		return session.update("questionboardMapper.updateQuestionLikeCount", board_no);
	}

	//좋아요 체크여부
	public QuestionLike selectQuestionLikeCheck(Map<String, Object> params) {
		return session.selectOne("questionboardMapper.selectQuestionLikeCheck",params);
	}



}
