package com.cono.dogrami.diaryreply.model.service;

import com.cono.dogrami.diaryreply.model.dao.DiaryReplyDao;
import com.cono.dogrami.diaryreply.model.vo.DiaryReply;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("diaryReplyService")
public class DiaryReplyServiceImpl implements DiaryReplyService {
    @Autowired
    private DiaryReplyDao diaryReplyDao;

	@Override
	public ArrayList<DiaryReply> selectList(int board_no) {
		return diaryReplyDao.selectList(board_no);
	}

	@Override
	public int selectDiaryReplyCount(int board_no) {
		return diaryReplyDao.selectDiaryReplyCount(board_no);
	}

	@Override
	public String selectnickname(int ref_no) {
		return diaryReplyDao.selectnickname(ref_no);
	}

	@Override
	public int insertDiaryReply(DiaryReply diaryreply) {
		return diaryReplyDao.insertDiaryReply(diaryreply);
	}

	@Override
	public int updateDiaryReply(DiaryReply diaryreply) {
		return diaryReplyDao.updateDiaryReply(diaryreply);
	}

	@Override
	public int deleteDiaryReply(int ref_no) {
		return diaryReplyDao.deleteDiaryReply(ref_no);
	}

    
    
    
}
