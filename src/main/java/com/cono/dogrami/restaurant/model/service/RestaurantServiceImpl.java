package com.cono.dogrami.restaurant.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.cafe.model.vo.Cafe;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.restaurant.model.dao.RestaurantDao;
import com.cono.dogrami.restaurant.model.vo.Restaurant;

@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;
	
	@Override
	public ArrayList<Restaurant> selectList(Paging page) {
		return restaurantDao.selectList(page);
	}

	@Override
	public int selectListCount() {
		return restaurantDao.selectListCount();
	}

	@Override
	public ArrayList<Restaurant> selectSearchList(Map<String, Object> params) {
		return restaurantDao.selectSearchList(params);
	}

	@Override
	public int selectListCountSearch(Map<String, Object> params) {
		return restaurantDao.selectListCountSearch(params);
	}
}
