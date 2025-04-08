package com.cono.dogrami.trainning.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.cafe.model.vo.Cafe;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.trainning.model.vo.Trainning;

@Repository("trainningDao")
public class TrainningDao {

	@Autowired
	private SqlSessionTemplate session; 
	
	public ArrayList<Trainning> selectList(Paging page) {
		List<Trainning> list = session.selectList("trainningMapper.selectList", page);
		return (ArrayList<Trainning>)list;
	}

	public int selectListCount() {
		return session.selectOne("trainningMapper.selectListCount");
		
	}

	public ArrayList<Trainning> selectSearchList(Map<String, Object> params) {
		List<Trainning> list = session.selectList("trainningMapper.selectSearchList", params);
		return (ArrayList<Trainning>)list;
	}

	public int selectListCountSearch(Map<String, Object> params) {
		List<Trainning> list = session.selectList("trainningMapper.selectListCountSearch", params);
		return list.size();
	}
}
