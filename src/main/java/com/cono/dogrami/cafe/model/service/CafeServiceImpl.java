package com.cono.dogrami.cafe.model.service;

import com.cono.dogrami.cafe.model.dao.CafeDao;
import com.cono.dogrami.cafe.model.vo.Cafe;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cafeService")
public class CafeServiceImpl implements CafeService {

    @Autowired
    private CafeDao cafeDao;

	@Override
	public ArrayList<Cafe> selectList() {
		return cafeDao.selectList();
	}
}
