package com.cono.dogrami.careboard.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.careboard.model.vo.CareBoard;

@Repository("CareBoardDao")
public class CareBoardDao {

	@Autowired
	private SqlSessionTemplate session;

	
	public ArrayList<CareBoard> SelectList() {
		return null;
	}

	
	public ArrayList<CareBoard> SelectNick(String keyword) {
		return null;
	}

	
	public ArrayList<CareBoard> SelectTtile(String keyword) {
		return null;
	}

	
	public ArrayList<CareBoard> SelectLocation(String keyword) {
		return null;
	}

	
	public int insertBoard(CareBoard board) {
		return 0;
	}

	
	public int updateBoard(CareBoard board) {
		return 0;
	}

	
	public int deleteBoard(int careNo) {
		return 0;
	}

	
	public CareBoard SelectOne(int careNo) {
		return null;
	}

	public int selectListCount() {
		return 0;
	}
}
