package com.cono.dogrami.placereply.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.placereply.model.dao.PlaceReplyDao;
import com.cono.dogrami.placereply.model.vo.PlaceReply;

@Service("PlaceReplyService")
public class PlaceReplyServiceImpl implements PlaceReplyService{

	@Autowired
	private PlaceReplyDao replyDao;

	@Override
	public ArrayList<PlaceReply> SelectList() {
		return null;
	}

	@Override
	public ArrayList<PlaceReply> SelectNick(String keyword) {
		return null;
	}

	@Override
	public ArrayList<PlaceReply> SelectTtile(String keyword) {
		return null;
	}

	@Override
	public ArrayList<PlaceReply> SelectLocation(String keyword) {
		return null;
	}

	@Override
	public int insertBoard(PlaceReply reply) {
		return 0;
	}

	@Override
	public int updateBoard(PlaceReply reply) {
		return 0;
	}

	@Override
	public int deleteBoard(int rep_no) {
		return 0;
	}

	@Override
	public PlaceReply SelectOne(int rep_no) {
		return null;
	}
	
	
}
