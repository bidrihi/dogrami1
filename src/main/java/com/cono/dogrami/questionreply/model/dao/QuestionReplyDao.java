package com.cono.dogrami.questionreply.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.questionreply.model.vo.QuestionReply;

@Repository("questionReplyDao")
public class QuestionReplyDao {
    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<QuestionReply> selectList(int board_no) {
		List<QuestionReply> list = session.selectList("questionreplyMapper.selectList", board_no);
		return (ArrayList<QuestionReply>) list;
	}

	public int selectQuestionReplyCount(int board_no) {
		return session.selectOne("questionreplyMapper.selectQuestionReplyCount",board_no);
	}

	public String selectnickname(int ref_no) {
		return session.selectOne("questionreplyMapper.selectnickname",ref_no);
	}

	public int insertQuestionReply(QuestionReply questionreply) {
		return session.insert("questionreplyMapper.insertQuestionReply",questionreply);
	}

	public int updateQuestionReply(QuestionReply questionreply) {
		return session.update("questionreplyMapper.updateQuestionReply",questionreply);
	}

	public int deleteQuestionReply(int ref_no) {
		return session.delete("questionreplyMapper.deleteQuestionReply", ref_no);
	}


}
