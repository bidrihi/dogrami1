package com.cono.dogrami.hospital.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.cafe.model.vo.Cafe;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.hospital.model.vo.Hospital;

@Repository("hospitalDao")
public class HospitalDao {
    @Autowired
    private SqlSessionTemplate session;

    public ArrayList<Hospital> selectList(Paging page) {
		List<Hospital> list = session.selectList("hospitalMapper.selectList", page);
		return (ArrayList<Hospital>)list;
	}

	public int selectListCount() {
		return session.selectOne("hospitalMapper.selectListCount");
		
	}

	public ArrayList<Hospital> selectSearchList(Map<String, Object> params) {
		List<Hospital> list = session.selectList("hospitalMapper.selectSearchList", params);
		return (ArrayList<Hospital>)list;
	}

	public int selectListCountSearch(Map<String, Object> params) {
		List<Hospital> list = session.selectList("hospitalMapper.selectListCountSearch", params);
		return list.size();
	}
}
