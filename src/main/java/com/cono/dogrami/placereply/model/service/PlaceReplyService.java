package com.cono.dogrami.placereply.model.service;

import java.util.ArrayList;

import com.cono.dogrami.placereply.model.vo.PlaceReply;

public interface PlaceReplyService {

	ArrayList<PlaceReply> SelectList();
	ArrayList<PlaceReply> SelectNick(String keyword);
	ArrayList<PlaceReply> SelectTtile(String keyword);
	ArrayList<PlaceReply> SelectLocation(String keyword);
	int insertBoard(PlaceReply reply);
	int updateBoard(PlaceReply reply);
	int deleteBoard(int rep_no);
	PlaceReply SelectOne(int rep_no);
}
