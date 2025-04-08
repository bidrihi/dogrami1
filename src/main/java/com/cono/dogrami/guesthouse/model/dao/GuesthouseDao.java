package com.cono.dogrami.guesthouse.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.cafe.model.vo.Cafe;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.guesthouse.model.vo.Guesthouse;

@Repository("guesthouseDao")
public class GuesthouseDao {
   
	@Autowired
    private SqlSessionTemplate session;
	
	public ArrayList<Guesthouse> selectList(Paging page) {
		List<Guesthouse> list = session.selectList("guesthouseMapper.selectList", page);
		return (ArrayList<Guesthouse>)list;
	}

	public int selectListCount() {
		return session.selectOne("guesthouseMapper.selectListCount");
		
	}

	public ArrayList<Guesthouse> selectSearchList(Map<String, Object> params) {
		List<Guesthouse> list = session.selectList("guesthouseMapper.selectSearchList", params);
		return (ArrayList<Guesthouse>)list;
	}

	public int selectListCountSearch(Map<String, Object> params) {
		List<Guesthouse> list = session.selectList("guesthouseMapper.selectListCountSearch", params);
		return list.size();
	}
}
