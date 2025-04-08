package com.cono.dogrami.questionreply.model.service;

import com.cono.dogrami.questionreply.model.dao.QuestionReplyDao;
import com.cono.dogrami.questionreply.model.vo.QuestionReply;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("questionReplyService")
public class QuestionReplyServiceImpl implements QuestionReplyService {
    @Autowired
    private QuestionReplyDao questionReplyDao;

	@Override
	public ArrayList<QuestionReply> selectList(int board_no) {
		return questionReplyDao.selectList(board_no);
	}

	@Override
	public int selectQuestionReplyCount(int board_no) {
		return questionReplyDao.selectQuestionReplyCount(board_no);
	}

	@Override
	public String selectnickname(int ref_no) {
		return questionReplyDao.selectnickname(ref_no);
	}

	@Override
	public int insertQuestionReply(QuestionReply questionreply) {
		return questionReplyDao.insertQuestionReply(questionreply);
	}

	@Override
	public int updateQuestionReply(QuestionReply questionreply) {
		return questionReplyDao.updateQuestionReply(questionreply);
	}

	@Override
	public int deleteQuestionReply(int ref_no) {
		return questionReplyDao.deleteQuestionReply(ref_no);
	}

    
    
    
}
