package com.cono.dogrami.funeral.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.funeral.model.vo.Funeral;

@Repository("funeralDao")
public class FuneralDao {
    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<Funeral> selectList() {
		List<Funeral> list = session.selectList("funeralMapper.selectList");
		return (ArrayList<Funeral>) list;
		
	}
}
