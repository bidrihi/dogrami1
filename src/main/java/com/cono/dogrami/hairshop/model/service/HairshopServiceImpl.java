package com.cono.dogrami.hairshop.model.service;

import com.cono.dogrami.hairshop.model.dao.HairshopDao;
import com.cono.dogrami.hairshop.model.vo.Hairshop;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hairshopService")
public class HairshopServiceImpl implements HairshopService{
    @Autowired
    private HairshopDao hairshopDao;

	@Override
	public ArrayList<Hairshop> selectList() {
		
		return hairshopDao.selectList();
	}
}
