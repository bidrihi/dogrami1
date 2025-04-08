package com.cono.dogrami.careboard.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.careboard.model.dao.CareBoardDao;
import com.cono.dogrami.careboard.model.vo.CareBoard;
import com.cono.dogrami.careboard.model.vo.CareLike;
import com.cono.dogrami.common.Paging;
@Service("careBoardService")
public class CareBoardServiceImpl implements CareBoardService {

	@Autowired
	private CareBoardDao careBoardDao;

	@Override
	public int selectListCount() {
		return careBoardDao.selectListCount();	
	}
	
	

	@Override
	public int selectListCountSearch(Map<String,Object> params) {
		return careBoardDao.selectListCountSearch(params);
	}
	
	@Override
	public int updateCount(int board_no) {
		return careBoardDao.updateCount(board_no);
		
	}
	
	@Override
	public int downUpdateCount(int board_no) {
		return careBoardDao.downUpdateCount(board_no);
		
	}
	
	@Override
	public ArrayList<CareBoard> selectList(Paging page) {
		return careBoardDao.selectList(page);
		
	}
	
	@Override
	public ArrayList<CareBoard> selectLocation(Map<String, Object> params){
		return careBoardDao.selectLocation(params);
	}

	@Override
	public int insertBoard(CareBoard careBoard) {
		return careBoardDao.insertBoard(careBoard);
	}

	@Override
	public int updateBoard(CareBoard careBoard) {
		return careBoardDao.updateBoard(careBoard);
	}

	@Override
	public int deleteBoard(CareBoard careBoard) {
		return careBoardDao.deleteBoard(careBoard);
	}

	@Override
	public CareBoard selectCareBoard(int board_no) {
		return careBoardDao.selectCareBoard(board_no);
	
	}

	@Override
	public ArrayList<CareBoard> selectSearch(Map<String,Object> params) {
		return careBoardDao.selectSearch(params);
	}

	@Override
	public int selectListLocatonCount(Map<String, Object> params) {
		return careBoardDao.selectListLocatonCount(params);
	}

	@Override
	public int insertCareLike(Map<String, Object> params) {
		return careBoardDao.insertCareLike(params);
		
	}

	@Override
	public int deleteCareLike(Map<String, Object> params) {
		return careBoardDao.deleteCareLike(params);
	}

	@Override
	public int updateCareLikeCount(int board_no) {
		return careBoardDao.updateCareLikeCount(board_no);
	}

	@Override
	public CareLike selectCareLikeCheck(Map<String, Object> params) {
		return careBoardDao.selectCareLikeCheck(params);
	}

	@Override
	public ArrayList<CareBoard> selectNewTop5() {
		return careBoardDao.selectNewTop5();
	}
}
