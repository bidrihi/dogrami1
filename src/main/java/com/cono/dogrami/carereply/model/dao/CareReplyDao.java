package com.cono.dogrami.carereply.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.carereply.model.vo.CareReply;

@Repository("careReplyDao")
public class CareReplyDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public ArrayList<CareReply> SelectList() {
		return null;
	}

	public ArrayList<CareReply> SelectNick(String keyword) {
		return null;
	}

	public ArrayList<CareReply> SelectTtile(String keyword) {
		return null;
	}

	public ArrayList<CareReply> SelectLocation(String keyword) {
		return null;
	}

	public int insertBoard(CareReply reply) {
		return 0;
	}

	public int updateBoard(CareReply reply) {
		return 0;
	}

	public int deleteBoard(int rep_no) {
		return 0;
	}

	public CareReply SelectOne(int rep_no) {
		return null;
	}
}
