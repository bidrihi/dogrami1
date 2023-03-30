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
    
	public Daily selectDailyBoard(int board_no) {
		return session.selectOne("dailyboardMapper.selectDailyBoard",board_no);
	}
	
	
	public int updateDailyBoardReadcount(int board_no) {
		return session.update("dailyboardMapper.updateDailyBoardReadcount",board_no);
	}

	public String selectnickname(int board_no) {
		return session.selectOne("dailyboardMapper.selectnickname",board_no);
	}
	
    public int selectListCount() {
        return session.selectOne("dailyboardMapper.selectListCount");
    }


    public int insertDailyBoard(Daily daily) {
        return session.insert("dailyboardMapper.insertDailyBoard",daily);
    }


    public int updateDailyBoard(Daily daily) {
        return 0;
    }


    public int deleteDailyBoard(Daily daily) {
        return 0;
    }




}
