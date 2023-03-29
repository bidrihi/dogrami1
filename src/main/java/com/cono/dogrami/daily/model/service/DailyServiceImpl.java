package com.cono.dogrami.daily.model.service;

import com.cono.dogrami.daily.model.dao.DailyDao;
import com.cono.dogrami.daily.model.vo.Daily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dailyService")
public class DailyServiceImpl implements DailyService {
    @Autowired
    private DailyDao dailyDao;

    @Override
    public int selectListCount() {
        return 0;
    }

    @Override
    public Daily selectDailyBoard(int board_no) {
        return null;
    }

    @Override
    public int updateDailyBoardReadcount(int board_no) {
        return 0;
    }

    @Override
    public int insertDailyBoard(Daily daily) {
        return 0;
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
