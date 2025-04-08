package com.cono.dogrami.placereply.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.placereply.model.dao.PlaceReplyDao;
import com.cono.dogrami.placereply.model.vo.PlaceReply;

@Service("placeReplyService")
public class PlaceReplyServiceImpl implements PlaceReplyService {

	@Autowired
	private PlaceReplyDao placeReplyDao; 

	@Override
	public ArrayList<PlaceReply> selectList(int board_no) {
		return placeReplyDao.selectList(board_no);
	}

	@Override
	public int insertReply(PlaceReply placeReply) {
		return placeReplyDao.insertReply(placeReply);
	}

	@Override
	public int updateReply(PlaceReply placeReply) {
		return placeReplyDao.updateReply(placeReply);
	}

	@Override
	public int deleteReply(int rep_no) {
		return placeReplyDao.deleteReply(rep_no);
	}
	
	@Override
	public int selectPlaceReplyCount(int board_no) {
		return placeReplyDao.selectPlaceReplyCount(board_no);
	}
	
	@Override
	public String selectnickname(int ref_no) {
		return placeReplyDao.selectnickname(ref_no);
	}

}
