package com.cono.dogrami.carereply.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.carereply.model.vo.CareReply;

@Repository("careReplyDao")
public class CareReplyDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public ArrayList<CareReply> selectList(int board_no) {
		List<CareReply> list = session.selectList("carereplyMapper.selectList",board_no);
		return (ArrayList<CareReply>)list;
	}


	public int insertReply(CareReply careReply) {
		return session.insert("carereplyMapper.insertReply", careReply);
	}

	public int updateReply(CareReply careReply) {
		return session.update("carereplyMapper.updateReply", careReply);
	}

	public int deleteReply(int ref_no) {
		return session.delete("carereplyMapper.deleteReply", ref_no);
	}


	public String selectnickname(int ref_no) {
		return session.selectOne("carereplyMapper.selectnickname",ref_no);
	}


	public int selectCareReplyCount(int board_no) {
		return session.selectOne("carereplyMapper.selectCareReplyCount", board_no);
	}

}
