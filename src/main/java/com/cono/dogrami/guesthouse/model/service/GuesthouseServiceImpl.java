package com.cono.dogrami.guesthouse.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.guesthouse.model.dao.GuesthouseDao;
import com.cono.dogrami.guesthouse.model.vo.Guesthouse;

@Service("guesthouseService")
public class GuesthouseServiceImpl implements GuesthouseService{
   
	@Autowired
    private GuesthouseDao guesthouseDao;

	@Override
	public ArrayList<Guesthouse> selectList() {
		return guesthouseDao.selectList();
	}
}
