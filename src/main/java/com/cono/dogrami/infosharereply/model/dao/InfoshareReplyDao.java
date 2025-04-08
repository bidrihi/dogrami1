package com.cono.dogrami.infosharereply.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.infosharereply.model.vo.InfoshareReply;

@Repository("infoshareReplyDao")
public class InfoshareReplyDao {
    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<InfoshareReply> selectList(int board_no) {
		List<InfoshareReply> list = session.selectList("infosharereplyMapper.selectList", board_no);
		return (ArrayList<InfoshareReply>) list;
	}

	public int selectInfoshareReplyCount(int board_no) {
		return session.selectOne("infosharereplyMapper.selectInfoshareReplyCount",board_no);
	}

	public String selectnickname(int ref_no) {
		return session.selectOne("infosharereplyMapper.selectnickname",ref_no);
	}

	public int insertInfoshareReply(InfoshareReply infosharereply) {
		return session.insert("infosharereplyMapper.insertInfoshareReply",infosharereply);
	}

	public int updateInfoshareReply(InfoshareReply infosharereply) {
		return session.update("infosharereplyMapper.updateInfoshareReply",infosharereply);
	}

	public int deleteInfoshareReply(int ref_no) {
		return session.delete("infosharereplyMapper.deleteInfoshareReply", ref_no);
	}


}
