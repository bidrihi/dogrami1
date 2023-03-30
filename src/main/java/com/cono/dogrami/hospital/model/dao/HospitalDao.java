package com.cono.dogrami.hospital.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.hospital.model.vo.Hospital;

@Repository("hospitalDao")
public class HospitalDao {
    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<Hospital> selectList() {
		List<Hospital> list = session.selectList("hospitalMapper.selectList");
		return (ArrayList<Hospital>)list;
		
	}
}
