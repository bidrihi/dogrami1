package com.cono.dogrami.hospital.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.hospital.model.dao.HospitalDao;
import com.cono.dogrami.hospital.model.vo.Hospital;

@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalDao hospitalDao;

	@Override
	public ArrayList<Hospital> selectList(Paging page) {
		return hospitalDao.selectList(page);
		
	}

	@Override
	public int selectListCount() {
		return hospitalDao.selectListCount();
	}
	
	@Override
	public ArrayList<Hospital> selectSearchList(Map<String, Object> params) {
		return hospitalDao.selectSearchList(params);
	}
	
	@Override
	public int selectListCountSearch(Map<String, Object> params) {
		return hospitalDao.selectListCountSearch(params);
	}
	
	
}
