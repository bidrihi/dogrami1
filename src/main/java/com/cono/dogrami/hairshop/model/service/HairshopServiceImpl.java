package com.cono.dogrami.hairshop.model.service;

import com.cono.dogrami.cafe.model.vo.Cafe;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.guesthouse.model.vo.Guesthouse;
import com.cono.dogrami.hairshop.model.dao.HairshopDao;
import com.cono.dogrami.hairshop.model.vo.Hairshop;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hairshopService")
public class HairshopServiceImpl implements HairshopService{
    @Autowired
    private HairshopDao hairshopDao;
    
    @Override
	public ArrayList<Hairshop> selectList(Paging page) {
		return hairshopDao.selectList(page);
	}

	@Override
	public int selectListCount() {
		return hairshopDao.selectListCount();
	}

	@Override
	public ArrayList<Hairshop> selectSearchList(Map<String, Object> params) {
		return hairshopDao.selectSearchList(params);
	}

	@Override
	public int selectListCountSearch(Map<String, Object> params) {
		return hairshopDao.selectListCountSearch(params);
	}
}
