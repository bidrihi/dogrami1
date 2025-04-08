package com.cono.dogrami.hairshop.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.hairshop.model.vo.Hairshop;

@Repository("hairshopDao")
public class HairshopDao {
    @Autowired
    private SqlSessionTemplate session;
    
    
    public ArrayList<Hairshop> selectList(Paging page) {
		List<Hairshop> list = session.selectList("hairshopMapper.selectList", page);
		return (ArrayList<Hairshop>)list;
	}

	public int selectListCount() {
		return session.selectOne("hairshopMapper.selectListCount");
		
	}

	public ArrayList<Hairshop> selectSearchList(Map<String, Object> params) {
		List<Hairshop> list = session.selectList("hairshopMapper.selectSearchList", params);
		return (ArrayList<Hairshop>)list;
	}

	public int selectListCountSearch(Map<String, Object> params) {
		List<Hairshop> list = session.selectList("hairshopMapper.selectListCountSearch", params);
		return list.size();
	}
	
}
