package com.cono.dogrami.diaryreply.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.diaryreply.model.vo.DiaryReply;

@Repository("diaryReplyDao")
public class DiaryReplyDao {
    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<DiaryReply> selectList(int board_no) {
		List<DiaryReply> list = session.selectList("diaryreplyMapper.selectList", board_no);
		return (ArrayList<DiaryReply>) list;
	}

	public int selectDiaryReplyCount(int board_no) {
		return session.selectOne("diaryreplyMapper.selectDiaryReplyCount",board_no);
	}

	public String selectnickname(int ref_no) {
		return session.selectOne("diaryreplyMapper.selectnickname",ref_no);
	}

	public int insertDiaryReply(DiaryReply diaryreply) {
		return session.insert("diaryreplyMapper.insertDiaryReply",diaryreply);
	}

	public int updateDiaryReply(DiaryReply diaryreply) {
		return session.update("diaryreplyMapper.updateDiaryReply",diaryreply);
	}

	public int deleteDiaryReply(int ref_no) {
		return session.delete("diaryreplyMapper.deleteDiaryReply", ref_no);
	}


}
