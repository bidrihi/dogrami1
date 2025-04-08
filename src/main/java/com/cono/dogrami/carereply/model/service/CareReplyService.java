package com.cono.dogrami.carereply.model.service;

import java.util.ArrayList;

import com.cono.dogrami.carereply.model.vo.CareReply;
public interface CareReplyService {

	//현재 게시글의 댓글조회
	ArrayList<CareReply> selectList(int board_no);
	
	//댓글 갯수
	int selectCareReplyCount(int board_no);
		
	//댓글 작성자의 닉네임
	String selectnickname(int ref_no);
	
	//게시글에 댓글추가
	int insertReply(CareReply careReply);
	
	//게시글 댓글수정
	int updateReply(CareReply careReply);
	
	//게시글 댓글삭제
	int deleteReply(int rep_no);
	
}
