package com.cono.dogrami.carereply.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.carereply.model.dao.CareReplyDao;
import com.cono.dogrami.carereply.model.vo.CareReply;

@Service("careReplyService")
public class CareReplyServiceImpl implements CareReplyService{

	@Autowired
	private CareReplyDao careReplyDao;

	@Override
	public ArrayList<CareReply> SelectList() {
		return null;
	}

	@Override
	public ArrayList<CareReply> SelectNick(String keyword) {
		return null;
	}

	@Override
	public ArrayList<CareReply> SelectTtile(String keyword) {
		return null;
	}

	@Override
	public ArrayList<CareReply> SelectLocation(String keyword) {
		return null;
	}

	@Override
	public int insertBoard(CareReply reply) {
		return 0;
	}

	@Override
	public int updateBoard(CareReply reply) {
		return 0;
	}

	@Override
	public int deleteBoard(int rep_no) {
		return 0;
	}

	@Override
	public CareReply SelectOne(int rep_no) {
		return null;
	}
}
