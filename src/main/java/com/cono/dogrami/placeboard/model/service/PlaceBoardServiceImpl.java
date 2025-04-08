package com.cono.dogrami.placeboard.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.placeboard.model.dao.PlaceBoardDao;
import com.cono.dogrami.placeboard.model.vo.PlaceBoard;
import com.cono.dogrami.placeboard.model.vo.PlaceLike;

@Service("placeBoardService")
public class PlaceBoardServiceImpl implements PlaceBoardService {

	@Autowired
	private PlaceBoardDao placeBoardDao;

	@Override
	public int selectListCount() {
		return placeBoardDao.selectListCount();
		
	}

	@Override
	public int selectListCountSearch(Map<String,Object> params) {
		return placeBoardDao.selectListCountSearch(params);
	}
	
	@Override
	public int updateCount(int board_no) {
		return placeBoardDao.updateCount(board_no);
		
	}
	
	@Override
	public int downUpdateCount(int board_no) {
		return placeBoardDao.downUpdateCount(board_no);
		
	}
	
	@Override
	public ArrayList<PlaceBoard> selectList(Paging page) {
		return placeBoardDao.selectList(page);
		
	}
	
	@Override
	public ArrayList<PlaceBoard> selectLocation(Map<String, Object> params){
		return placeBoardDao.selectLocation(params);
	}

	@Override
	public int insertBoard(PlaceBoard placeBoard) {
		return placeBoardDao.insertBoard(placeBoard);
	}

	@Override
	public int updateBoard(PlaceBoard placeBoard) {
		return placeBoardDao.updateBoard(placeBoard);
	}

	@Override
	public int deleteBoard(PlaceBoard placeBoard) {
		return placeBoardDao.deleteBoard(placeBoard);
	}

	@Override
	public PlaceBoard selectPlaceBoard(int board_no) {
		return placeBoardDao.selectPlaceBoard(board_no);
	
	}

	@Override
	public ArrayList<PlaceBoard> selectSearch(Map<String,Object> params) {
		return placeBoardDao.selectSearch(params);
	}

	@Override
	public int selectListLocatonCount(Map<String, Object> params) {
		return placeBoardDao.selectListLocatonCount(params);
	}

	@Override
	public int insertPlaceLike(Map<String, Object> params) {
		return placeBoardDao.insertPlaceLike(params);
		
	}

	@Override
	public int deletePlaceLike(Map<String, Object> params) {
		return placeBoardDao.deletePlaceLike(params);
	}

	@Override
	public int updatePlaceLikeCount(int board_no) {
		return placeBoardDao.updatePlaceLikeCount(board_no);
	}

	@Override
	public PlaceLike selectPlaceLikeCheck(Map<String, Object> params) {
		return placeBoardDao.selectPlaceLikeCheck(params);
	}

	@Override
	public ArrayList<PlaceBoard> selectNewTop5() {
		return placeBoardDao.selectNewTop5();
	}
}
