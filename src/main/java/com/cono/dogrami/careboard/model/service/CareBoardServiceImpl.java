package com.cono.dogrami.careboard.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.careboard.model.dao.CareBoardDao;
import com.cono.dogrami.careboard.model.vo.CareBoard;
@Service("careBoardService")
public class CareBoardServiceImpl implements CareBoardService {

	@Autowired
	private CareBoardDao careBoardDao;
	
	@Override
	public ArrayList<CareBoard> SelectList() {
		return null;
	}

	@Override
	public ArrayList<CareBoard> SelectNick(String keyword) {
		return null;
	}

	@Override
	public ArrayList<CareBoard> SelectTtile(String keyword) {
		return null;
	}

	@Override
	public ArrayList<CareBoard> SelectLocation(String keyword) {
		return null;
	}

	@Override
	public int insertBoard(CareBoard board) {
		return 0;
	}

	@Override
	public int updateBoard(CareBoard board) {
		return 0;
	}

	@Override
	public int deleteBoard(int careNo) {
		return 0;
	}

	@Override
	public CareBoard SelectOne(int careNo) {
		return null;
	}

	@Override
	public int selectListCount() {
		return 0;
	}

	
}
