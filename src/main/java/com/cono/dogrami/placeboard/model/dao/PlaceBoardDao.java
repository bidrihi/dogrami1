package com.cono.dogrami.placeboard.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.placeboard.model.vo.PlaceBoard;

@Repository("placeBoardDao")
public class PlaceBoardDao {

	@Autowired
	private SqlSessionTemplate session;

	public ArrayList<PlaceBoard> SelectList() {
		return null;
	}

	public ArrayList<PlaceBoard> SelectNick(String keyword) {
		return null;
	}

	public ArrayList<PlaceBoard> SelectTtile(String keyword) {
		return null;
	}

	public ArrayList<PlaceBoard> SelectLocation(String keyword) {
		return null;
	}

	public int insertBoard(PlaceBoard board) {
		return 0;
	}

	public int updateBoard(PlaceBoard board) {
		return 0;
	}

	public int deleteBoard(int boardNo) {
		return 0;
	}

	public PlaceBoard SelectOne(int boardNo) {
		return null;
	}

}
