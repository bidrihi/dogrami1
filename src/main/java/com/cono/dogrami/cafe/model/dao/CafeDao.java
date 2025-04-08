package com.cono.dogrami.cafe.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.cafe.model.vo.Cafe;
import com.cono.dogrami.common.Paging;

@Repository("cafeDao")
public class CafeDao {

    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<Cafe> selectList(Paging page) {
		List<Cafe> list = session.selectList("cafeMapper.selectList", page);
		return (ArrayList<Cafe>)list;
	}

	public int selectListCount() {
		return session.selectOne("cafeMapper.selectListCount");
		
	}

	public ArrayList<Cafe> selectSearchList(Map<String, Object> params) {
		List<Cafe> list = session.selectList("cafeMapper.selectSearchList", params);
		return (ArrayList<Cafe>)list;
	}

	public int selectListCountSearch(Map<String, Object> params) {
		List<Cafe> list = session.selectList("cafeMapper.selectListCountSearch", params);
		return list.size();
	}
}
