package com.cono.dogrami.hotel.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.hotel.model.dao.HotelDao;
import com.cono.dogrami.hotel.model.vo.Hotel;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDao hotelDao;
    
    @Override
	public ArrayList<Hotel> selectList(Paging page) {
		return hotelDao.selectList(page);
	}

	@Override
	public int selectListCount() {
		return hotelDao.selectListCount();
	}

	@Override
	public ArrayList<Hotel> selectSearchList(Map<String, Object> params) {
		return hotelDao.selectSearchList(params);
	}

	@Override
	public int selectListCountSearch(Map<String, Object> params) {
		return hotelDao.selectListCountSearch(params);
	}
}
