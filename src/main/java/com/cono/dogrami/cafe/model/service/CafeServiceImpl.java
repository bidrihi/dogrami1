package com.cono.dogrami.cafe.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.cafe.model.dao.CafeDao;
import com.cono.dogrami.cafe.model.vo.Cafe;
import com.cono.dogrami.common.Paging;

@Service("cafeService")
public class CafeServiceImpl implements CafeService {

    @Autowired
    private CafeDao cafeDao;

	@Override
	public ArrayList<Cafe> selectList(Paging page) {
		return cafeDao.selectList(page);
	}

	@Override
	public int selectListCount() {
		return cafeDao.selectListCount();
	}

	@Override
	public ArrayList<Cafe> selectSearchList(Map<String, Object> params) {
		return cafeDao.selectSearchList(params);
	}

	@Override
	public int selectListCountSearch(Map<String, Object> params) {
		return cafeDao.selectListCountSearch(params);
	}
	

	
}
