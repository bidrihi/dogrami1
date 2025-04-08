package com.cono.dogrami.daily.model.dao;

import com.cono.dogrami.daily.model.vo.Daily;
import com.cono.dogrami.daily.model.vo.DailyLike;
import com.cono.dogrami.common.Paging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dailyDao")
public class DailyDao {

    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<Daily> selectList(Paging page) {
	List<Daily> list = session.selectList("dailyboardMapper.selectList", page);
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
	
	public ArrayList<Daily> selectSearch(Map<String, Object> params) {
		List<Daily> list = session.selectList("dailyboardMapper.selectSearch", params);
		return (ArrayList<Daily>)list;
	}
	
    public int selectListCount() {
        return session.selectOne("dailyboardMapper.selectListCount");
    }


    public int insertDailyBoard(Daily daily) {
        return session.insert("dailyboardMapper.insertDailyBoard",daily);
    }


    public int updateDailyBoard(Daily daily) {
        return session.update("dailyboardMapper.updateDailyBoard",daily);
    }


    public int deleteDailyBoard(int board_no) {
        return session.delete("dailyboardMapper.deleteDailyBoard",board_no);
    }

    public int selectListCountSearch(Map<String, Object> params) {
		List<Daily> list = session.selectList("dailyboardMapper.selectListCountSearch", params);
		return list.size();
    }
    
    //좋아요 증가
    public int insertDailyLike(Map<String, Object> params) {
    	return session.insert("dailyboardMapper.insertDailyLike", params);
    }

    //좋아요 감소
    public int deleteDailyLike(Map<String, Object> params) {
    	return session.delete("dailyboardMapper.deleteDailyLike", params);
    }

    //게시판 좋아요 컬럼 숫자증가
	public int updateDailyLikeCount(int board_no) {
		return session.update("dailyboardMapper.updateDailyLikeCount", board_no);
	}

	//좋아요 체크여부
	public DailyLike selectDailyLikeCheck(Map<String, Object> params) {
		return session.selectOne("dailyboardMapper.selectDailyLikeCheck",params);
	}



}
