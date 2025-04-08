package com.cono.dogrami.questionreply.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.questionreply.model.vo.QuestionReply;


public interface QuestionReplyService {
	
	//댓글 목록
	ArrayList<QuestionReply> selectList(int board_no);
	
	//댓글 갯수
	int selectQuestionReplyCount(int board_no);
	
	//댓글 작성자의 닉네임
	String selectnickname(int ref_no);
	
	//댓글 작성
	int insertQuestionReply(QuestionReply questionreply);

	//댓글 수정
	int updateQuestionReply(QuestionReply questionreply);

	//댓글 삭제
	int deleteQuestionReply(int ref_no);


}
