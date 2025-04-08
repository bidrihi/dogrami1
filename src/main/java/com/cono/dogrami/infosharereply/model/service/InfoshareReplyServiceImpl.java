package com.cono.dogrami.infosharereply.model.service;

import com.cono.dogrami.infosharereply.model.dao.InfoshareReplyDao;
import com.cono.dogrami.infosharereply.model.vo.InfoshareReply;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("infoshareReplyService")
public class InfoshareReplyServiceImpl implements InfoshareReplyService {
    @Autowired
    private InfoshareReplyDao infoshareReplyDao;

	@Override
	public ArrayList<InfoshareReply> selectList(int board_no) {
		return infoshareReplyDao.selectList(board_no);
	}

	@Override
	public int selectInfoshareReplyCount(int board_no) {
		return infoshareReplyDao.selectInfoshareReplyCount(board_no);
	}

	@Override
	public String selectnickname(int ref_no) {
		return infoshareReplyDao.selectnickname(ref_no);
	}

	@Override
	public int insertInfoshareReply(InfoshareReply infosharereply) {
		return infoshareReplyDao.insertInfoshareReply(infosharereply);
	}

	@Override
	public int updateInfoshareReply(InfoshareReply infosharereply) {
		return infoshareReplyDao.updateInfoshareReply(infosharereply);
	}

	@Override
	public int deleteInfoshareReply(int ref_no) {
		return infoshareReplyDao.deleteInfoshareReply(ref_no);
	}

    
    
    
}
