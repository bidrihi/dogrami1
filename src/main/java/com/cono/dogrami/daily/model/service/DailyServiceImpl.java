package com.cono.dogrami.daily.model.service;

import com.cono.dogrami.daily.model.dao.DailyDao;
import com.cono.dogrami.daily.model.vo.DailyLike;
import com.cono.dogrami.daily.model.vo.Daily;
import com.cono.dogrami.common.Paging;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dailyService")
public class DailyServiceImpl implements DailyService {
    
	@Autowired
    private DailyDao dailyDao;
	
	//게시글 리스트
	@Override
	public ArrayList<Daily> selectList(Paging page) {
		return dailyDao.selectList(page);
	}

	//게시글 검색
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
	
	//게시글 목록 검색
	@Override
	public ArrayList<Daily> selectSearch(Map<String, Object> params) {
		return dailyDao.selectSearch(params);
	}
	
	//게시글 검색시 목록 갯수
    @Override
    public int selectListCount() {
        return dailyDao.selectListCount();
    }

    //게시글 삭제
	@Override
	public int deleteDailyBoard(int board_no) {
		return dailyDao.deleteDailyBoard(board_no);
	}

    //게시글 작성
    @Override
    public int insertDailyBoard(Daily daily) {
        return dailyDao.insertDailyBoard(daily);
    }

    //게시글 수정
    @Override
    public int updateDailyBoard(Daily daily) {
        return dailyDao.updateDailyBoard(daily);
    }
    
    //게시글 검색
    @Override
	public int selectListCountSearch(Map<String, Object> params) {
		return dailyDao.selectListCountSearch(params);
	}

    //좋아요 증가
    @Override
    public int insertDailyLike(Map<String, Object> params) {
    	return dailyDao.insertDailyLike(params);
    }

    //좋아요 감소
    @Override
    public int deleteDailyLike(Map<String, Object> params) {
    	return dailyDao.deleteDailyLike(params);
    }
    
    //게시판 좋아요 컬럼 숫자증가
	@Override
	public int updateDailyLikeCount(int board_no) {
		return dailyDao.updateDailyLikeCount(board_no);
	}

	//좋아요 체크여부
	@Override
	public DailyLike selectDailyLikeCheck(Map<String, Object> params) {
		return dailyDao.selectDailyLikeCheck(params);
	}











}
