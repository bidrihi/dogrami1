package com.cono.dogrami.placereply.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.placereply.model.vo.PlaceReply;

@Repository("placeReplyDao")
public class PlaceReplyDao {

	@Autowired
	private SqlSessionTemplate session;

	public ArrayList<PlaceReply> selectList(int board_no) {
		List<PlaceReply> list = session.selectList("placereplyMapper.selectList",board_no);
		return (ArrayList<PlaceReply>)list;
	}


	public int insertReply(PlaceReply placeReply) {
		return session.insert("placereplyMapper.insertReply", placeReply);
	}

	public int updateReply(PlaceReply placeReply) {
		return session.update("placereplyMapper.updateReply", placeReply);
	}

	public int deleteReply(int rep_no) {
		return session.delete("placereplyMapper.deleteReply", rep_no);
	}

	public String selectnickname(int ref_no) {
		return session.selectOne("placereplyMapper.selectnickname",ref_no);
	}


	public int selectPlaceReplyCount(int board_no) {
		return session.selectOne("placereplyMapper.selectPlaceReplyCount", board_no);
	}
}
