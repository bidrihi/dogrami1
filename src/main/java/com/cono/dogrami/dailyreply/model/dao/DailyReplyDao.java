package com.cono.dogrami.dailyreply.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.dailyreply.model.vo.DailyReply;

@Repository("dailyReplyDao")
public class DailyReplyDao {
    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<DailyReply> selectList(int board_no) {
		List<DailyReply> list = session.selectList("dailyreplyMapper.selectList", board_no);
		return (ArrayList<DailyReply>) list;
	}

	public int selectDailyReplyCount(int board_no) {
		return session.selectOne("dailyreplyMapper.selectDailyReplyCount",board_no);
	}

	public String selectnickname(int ref_no) {
		return session.selectOne("dailyreplyMapper.selectnickname",ref_no);
	}

	public int insertDailyReply(DailyReply dailyreply) {
		return session.insert("dailyreplyMapper.insertDailyReply",dailyreply);
	}

	public int updateDailyReply(DailyReply dailyreply) {
		return session.update("dailyreplyMapper.updateDailyReply",dailyreply);
	}

	public int deleteDailyReply(int ref_no) {
		return session.delete("dailyreplyMapper.deleteDailyReply", ref_no);
	}


}
