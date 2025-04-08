package com.cono.dogrami.diaryreply.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.diaryreply.model.vo.DiaryReply;


public interface DiaryReplyService {
	
	//댓글 목록
	ArrayList<DiaryReply> selectList(int board_no);
	
	//댓글 갯수
	int selectDiaryReplyCount(int board_no);
	
	//댓글 작성자의 닉네임
	String selectnickname(int ref_no);
	
	//댓글 작성
	int insertDiaryReply(DiaryReply diaryreply);

	//댓글 수정
	int updateDiaryReply(DiaryReply diaryreply);

	//댓글 삭제
	int deleteDiaryReply(int ref_no);


}
