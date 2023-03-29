package com.cono.dogrami.trainning.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.trainning.model.vo.Trainning;

@Repository("trainningDao")
public class TrainningDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public ArrayList<Trainning> selectList() {
		List<Trainning> list = session.selectList("trainningMapper.selectList");
		return (ArrayList<Trainning>)list;
	}
}
