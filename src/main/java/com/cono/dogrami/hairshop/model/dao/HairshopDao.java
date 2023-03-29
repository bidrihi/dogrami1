package com.cono.dogrami.hairshop.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.hairshop.model.vo.Hairshop;

@Repository("hairshopDao")
public class HairshopDao {
    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<Hairshop> selectList() {	
		List<Hairshop> list = session.selectList("hairshopMapper.selectList");	
		return (ArrayList<Hairshop>)list;
	}
}
