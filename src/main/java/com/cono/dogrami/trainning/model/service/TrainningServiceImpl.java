package com.cono.dogrami.trainning.model.service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.cafe.model.vo.Cafe;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.trainning.model.dao.TrainningDao;
import com.cono.dogrami.trainning.model.vo.Trainning;

@Service("tranningService")
public class TrainningServiceImpl implements TrainningService {

	@Autowired
	private TrainningDao trainningDao;
	
	@Override
	public ArrayList<Trainning> selectList(Paging page) {
		return trainningDao.selectList(page);
	}

	@Override
	public int selectListCount() {
		return trainningDao.selectListCount();
	}

	@Override
	public ArrayList<Trainning> selectSearchList(Map<String, Object> params) {
		return trainningDao.selectSearchList(params);
	}

	@Override
	public int selectListCountSearch(Map<String, Object> params) {
		return trainningDao.selectListCountSearch(params);
	}
}
