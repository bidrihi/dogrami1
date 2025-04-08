package com.cono.dogrami.dailyreply.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.dailyreply.model.vo.DailyReply;


public interface DailyReplyService {
	
	//댓글 목록
	ArrayList<DailyReply> selectList(int board_no);
	
	//댓글 갯수
	int selectDailyReplyCount(int board_no);
	
	//댓글 작성자의 닉네임
	String selectnickname(int ref_no);
	
	//댓글 작성
	int insertDailyReply(DailyReply dailyreply);

	//댓글 수정
	int updateDailyReply(DailyReply dailyreply);

	//댓글 삭제
	int deleteDailyReply(int ref_no);


}
