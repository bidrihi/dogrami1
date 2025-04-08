package com.cono.dogrami.hotel.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.cafe.model.vo.Cafe;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.guesthouse.model.vo.Guesthouse;
import com.cono.dogrami.hotel.model.vo.Hotel;

@Repository("hotelDao")
public class HotelDao {
   
	@Autowired
    private SqlSessionTemplate session;
	
	
	public ArrayList<Hotel> selectList(Paging page) {
		List<Hotel> list = session.selectList("hotelMapper.selectList", page);
		return (ArrayList<Hotel>)list;
	}

	public int selectListCount() {
		return session.selectOne("hotelMapper.selectListCount");
		
	}

	public ArrayList<Hotel> selectSearchList(Map<String, Object> params) {
		List<Hotel> list = session.selectList("hotelMapper.selectSearchList", params);
		return (ArrayList<Hotel>)list;
	}

	public int selectListCountSearch(Map<String, Object> params) {
		List<Hotel> list = session.selectList("hotelMapper.selectListCountSearch", params);
		return list.size();
	}
}
