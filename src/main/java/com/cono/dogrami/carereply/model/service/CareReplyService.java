package com.cono.dogrami.carereply.model.service;

import java.util.ArrayList;

import com.cono.dogrami.carereply.model.vo.CareReply;
public interface CareReplyService {

	ArrayList<CareReply> SelectList();
	ArrayList<CareReply> SelectNick(String keyword);
	ArrayList<CareReply> SelectTtile(String keyword);
	ArrayList<CareReply> SelectLocation(String keyword);
	int insertBoard(CareReply reply);
	int updateBoard(CareReply reply);
	int deleteBoard(int rep_no);
	CareReply SelectOne(int rep_no);
}
