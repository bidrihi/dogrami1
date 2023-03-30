package com.cono.dogrami.guesthouse.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.guesthouse.model.vo.Guesthouse;

@Repository("guesthouseDao")
public class GuesthouseDao {
   
	@Autowired
    private SqlSessionTemplate session;

	public ArrayList<Guesthouse> selectList() {
		List<Guesthouse> list = session.selectList("guesthouseMapper.selectList");
		return (ArrayList<Guesthouse>)list;
		
	}
}
