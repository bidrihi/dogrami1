package com.cono.dogrami.placeboard.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.placeboard.model.dao.PlaceBoardDao;
import com.cono.dogrami.placeboard.model.vo.PlaceBoard;

@Service("PlaceBoardService")
public class PlaceBoardServiceImpl implements PlaceBoardService {

	@Autowired
	private PlaceBoardDao boardDao;

	@Override
	public ArrayList<PlaceBoard> SelectList() {
		return null;
	}

	@Override
	public ArrayList<PlaceBoard> SelectNick(String keyword) {
		return null;
	}

	@Override
	public ArrayList<PlaceBoard> SelectTtile(String keyword) {
		return null;
	}

	@Override
	public ArrayList<PlaceBoard> SelectLocation(String keyword) {
		return null;
	}

	@Override
	public int insertBoard(PlaceBoard board) {
		return 0;
	}

	@Override
	public int updateBoard(PlaceBoard board) {
		return 0;
	}

	@Override
	public int deleteBoard(int boardNo) {
		return 0;
	}

	@Override
	public PlaceBoard SelectOne(int boardNo) {
		return null;
	}

	@Override
	public int selectListCount() {
		return 0;
	}

}
