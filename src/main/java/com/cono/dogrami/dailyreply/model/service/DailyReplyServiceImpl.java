package com.cono.dogrami.dailyreply.model.service;

import com.cono.dogrami.dailyreply.model.dao.DailyReplyDao;
import com.cono.dogrami.dailyreply.model.vo.DailyReply;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dailyReplyService")
public class DailyReplyServiceImpl implements DailyReplyService {
    @Autowired
    private DailyReplyDao dailyReplyDao;

	@Override
	public ArrayList<DailyReply> selectList(int board_no) {
		return dailyReplyDao.selectList(board_no);
	}

	@Override
	public int selectDailyReplyCount(int board_no) {
		return dailyReplyDao.selectDailyReplyCount(board_no);
	}

	@Override
	public String selectnickname(int ref_no) {
		return dailyReplyDao.selectnickname(ref_no);
	}

	@Override
	public int insertDailyReply(DailyReply dailyreply) {
		return dailyReplyDao.insertDailyReply(dailyreply);
	}

	@Override
	public int updateDailyReply(DailyReply dailyreply) {
		return dailyReplyDao.updateDailyReply(dailyreply);
	}

	@Override
	public int deleteDailyReply(int ref_no) {
		return dailyReplyDao.deleteDailyReply(ref_no);
	}

    
    
    
}
