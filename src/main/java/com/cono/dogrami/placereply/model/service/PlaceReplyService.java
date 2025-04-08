package com.cono.dogrami.placereply.model.service;

import java.util.ArrayList;

import com.cono.dogrami.carereply.model.vo.CareReply;
import com.cono.dogrami.placereply.model.vo.PlaceReply;

public interface PlaceReplyService {

	//현재 게시글의 댓글조회
		ArrayList<PlaceReply> selectList(int board_no);
		
		//댓글 갯수
		int selectPlaceReplyCount(int board_no);
			
		//댓글 작성자의 닉네임
		String selectnickname(int ref_no);
		
		//게시글에 댓글추가
		int insertReply(PlaceReply placeReply);
		
		//게시글 댓글수정
		int updateReply(PlaceReply placeReply);
		
		//게시글 댓글삭제
		int deleteReply(int rep_no);
}
