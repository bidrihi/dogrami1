package com.cono.dogrami.infosharereply.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.infosharereply.model.vo.InfoshareReply;


public interface InfoshareReplyService {
	
	//댓글 목록
	ArrayList<InfoshareReply> selectList(int board_no);
	
	//댓글 갯수
	int selectInfoshareReplyCount(int board_no);
	
	//댓글 작성자의 닉네임
	String selectnickname(int ref_no);
	
	//댓글 작성
	int insertInfoshareReply(InfoshareReply infosharereply);

	//댓글 수정
	int updateInfoshareReply(InfoshareReply infosharereply);

	//댓글 삭제
	int deleteInfoshareReply(int ref_no);


}
