package com.cono.dogrami.funeral.model.service;

import com.cono.dogrami.cafe.model.vo.Cafe;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.funeral.model.dao.FuneralDao;
import com.cono.dogrami.funeral.model.vo.Funeral;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("funeralService")
public class FuneralServiceImpl implements FuneralService {
    @Autowired
    private FuneralDao funeralDao;

    @Override
	public ArrayList<Funeral> selectList(Paging page) {
		return funeralDao.selectList(page);
	}

	@Override
	public int selectListCount() {
		return funeralDao.selectListCount();
	}

	@Override
	public ArrayList<Funeral> selectSearchList(Map<String, Object> params) {
		return funeralDao.selectSearchList(params);
	}

	@Override
	public int selectListCountSearch(Map<String, Object> params) {
		return funeralDao.selectListCountSearch(params);
	}
}
