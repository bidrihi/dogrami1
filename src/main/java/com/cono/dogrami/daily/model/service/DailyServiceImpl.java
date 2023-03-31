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
	
	//게시글 조회수 증가
	@Override
	public int updateDailyBoardReadcount(int board_no) {
		return dailyDao.updateDailyBoardReadcount(board_no);
	}
	
	//조인해서 닉네임 가져오기
	@Override
	public String selectnickname(int board_no) {
		return dailyDao.selectnickname(board_no);
	}
	
	//게시글 목록 검색바에서 제목으로 검색
	@Override
	public ArrayList<Daily> selectDailyBoardtitle(String keyword) {
		return dailyDao.selectDailyBoardtitle(keyword);
	}
	
	//게시글 목록 검색바에서 작성자로 검색
	@Override
	public ArrayList<Daily> selectDailyBoardwriter(String keyword) {
		return dailyDao.selectDailyBoardwriter(keyword);
	}

	//게시글 목록 검색바에서 내용으로 검색
	@Override
	public ArrayList<Daily> selectDailyBoardcontent(String keyword) {
		return dailyDao.selectDailyBoardcontent(keyword);
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
        return dailyDao.updateDailyBoard(daily);
    }

    @Override
    public int deleteDailyBoard(Daily daily) {
        return 0;
    }









}
