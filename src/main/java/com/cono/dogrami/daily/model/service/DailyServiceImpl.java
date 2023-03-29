package com.cono.dogrami.daily.model.service;

import com.cono.dogrami.daily.model.dao.DailyDao;
import com.cono.dogrami.daily.model.vo.Daily;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dailyService")
public class DailyServiceImpl implements DailyService {
    @Autowired
    private DailyDao dailyDao;
    
	@Override
	public ArrayList<Daily> selectList() {
		return dailyDao.selectList();
	}

	@Override
	public Daily selectDailyBoard(int board_no) {
		return dailyDao.selectDailyBoard(board_no);
	}
	
	@Override
	public int updateDailyBoardReadcount(int board_no) {
		return dailyDao.updateDailyBoardReadcount(board_no);
	}
	
	//조인해서 닉네임 가져오기
	@Override
	public String selectnickname(int board_no) {
		return dailyDao.selectnickname(board_no);
	}
	
    @Override
    public int selectListCount() {
        return dailyDao.selectListCount();
    }


    @Override
    public int insertDailyBoard(Daily daily) {
        return dailyDao.insertDailyBoard(daily);
    }

    @Override
    public int updateDailyBoard(Daily daily) {
        return 0;
    }

    @Override
    public int deleteDailyBoard(Daily daily) {
        return 0;
    }






}
