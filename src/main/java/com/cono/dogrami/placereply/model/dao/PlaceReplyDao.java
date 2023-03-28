package com.cono.dogrami.placereply.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.placereply.model.vo.PlaceReply;

@Repository("PlaceReplyDao")
public class PlaceReplyDao {

	@Autowired
	private SqlSessionTemplate session;

	public ArrayList<PlaceReply> SelectList() {
		return null;
	}

	public ArrayList<PlaceReply> SelectNick(String keyword) {
		return null;
	}

	public ArrayList<PlaceReply> SelectTtile(String keyword) {
		return null;
	}

	public ArrayList<PlaceReply> SelectLocation(String keyword) {
		return null;
	}

	public int insertBoard(PlaceReply reply) {
		return 0;
	}

	public int updateBoard(PlaceReply reply) {
		return 0;
	}

	public int deleteBoard(int rep_no) {
		return 0;
	}

	public PlaceReply SelectOne(int rep_no) {
		return null;
	}
}
