package com.cono.dogrami.daily.model.dao;

import com.cono.dogrami.daily.model.vo.Daily;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dailyDao")
public class DailyDao {

    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<Daily> selectList() {
	List<Daily> list = session.selectList("dailyboardMapper.selectList");
		return (ArrayList<Daily>)list;
	}
    

    public int selectListCount() {
        return 0;
    }


    public Daily selectDailyBoard(int board_no) {
        return null;
    }


    public int updateDailyBoardReadcount(int board_no) {
        return 0;
    }


    public int insertDailyBoard(Daily daily) {
        return 0;
    }


    public int updateDailyBoard(Daily daily) {
        return 0;
    }


    public int deleteDailyBoard(Daily daily) {
        return 0;
    }


}
