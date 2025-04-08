package com.cono.dogrami.carereply.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.carereply.model.dao.CareReplyDao;
import com.cono.dogrami.carereply.model.vo.CareReply;

@Service("careReplyService")
public class CareReplyServiceImpl implements CareReplyService{

	@Autowired
	private CareReplyDao careReplyDao;

	@Override
	public ArrayList<CareReply> selectList(int board_no) {
		return careReplyDao.selectList(board_no);
	}
	@Override
	public int insertReply(CareReply careReply) {
		return careReplyDao.insertReply(careReply);
	}

	@Override
	public int updateReply(CareReply careReply) {
		return careReplyDao.updateReply(careReply);
	}

	@Override
	public int deleteReply(int ref_no) {
		return careReplyDao.deleteReply(ref_no);
	}
	@Override
	public int selectCareReplyCount(int board_no) {
		return careReplyDao.selectCareReplyCount(board_no);
	}
	
	@Override
	public String selectnickname(int ref_no) {
		return careReplyDao.selectnickname(ref_no);
	}

}
