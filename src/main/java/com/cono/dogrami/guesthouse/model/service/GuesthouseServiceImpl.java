package com.cono.dogrami.guesthouse.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.guesthouse.model.dao.GuesthouseDao;
import com.cono.dogrami.guesthouse.model.vo.Guesthouse;


@Service("guesthouseService")
public class GuesthouseServiceImpl implements GuesthouseService{
	
	@Autowired
    private GuesthouseDao guesthouseDao;

	@Override
	public ArrayList<Guesthouse> selectList(Paging page) {
		return guesthouseDao.selectList(page);
	}

	@Override
	public int selectListCount() {
		return guesthouseDao.selectListCount();
	}

	@Override
	public ArrayList<Guesthouse> selectSearchList(Map<String, Object> params) {
		return guesthouseDao.selectSearchList(params);
	}

	@Override
	public int selectListCountSearch(Map<String, Object> params) {
		return guesthouseDao.selectListCountSearch(params);
	}
}
