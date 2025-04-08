package com.cono.dogrami.funeral.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.funeral.model.vo.Funeral;

@Repository("funeralDao")
public class FuneralDao {
    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<Funeral> selectList(Paging page) {
		List<Funeral> list = session.selectList("funeralMapper.selectList", page);
		return (ArrayList<Funeral>) list;
		
	}
	
	public int selectListCount() {
		return session.selectOne("funeralMapper.selectListCount");
		
	}

	public ArrayList<Funeral> selectSearchList(Map<String, Object> params) {
		List<Funeral> list = session.selectList("funeralMapper.selectSearchList", params);
		return (ArrayList<Funeral>) list;
	}
	
	public int selectListCountSearch(Map<String, Object> params) {
		List<Funeral> list = session.selectList("funeralMapper.selectListCountSearch", params);
		return list.size();
	}
}

