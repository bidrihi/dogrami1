package com.cono.dogrami.hospital.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.hospital.model.dao.HospitalDao;
import com.cono.dogrami.hospital.model.vo.Hospital;

@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalDao hospitalDao;

	@Override
	public ArrayList<Hospital> selectList() {
		return hospitalDao.selectList();
		
	}
}
