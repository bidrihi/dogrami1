package com.cono.dogrami.restaurant.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.restaurant.model.vo.Restaurant;

@Repository("restaurantDao")
public class RestaurantDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public ArrayList<Restaurant> selectList(Paging page) {
		List<Restaurant> list = session.selectList("restaurantMapper.selectList", page);
		return (ArrayList<Restaurant>)list;
	}

	public int selectListCount() {
		return session.selectOne("restaurantMapper.selectListCount");
		
	}

	public ArrayList<Restaurant> selectSearchList(Map<String, Object> params) {
		List<Restaurant> list = session.selectList("restaurantMapper.selectSearchList", params);
		return (ArrayList<Restaurant>)list;
	}

	public int selectListCountSearch(Map<String, Object> params) {
		List<Restaurant> list = session.selectList("restaurantMapper.selectListCountSearch", params);
		return list.size();
	}
}
