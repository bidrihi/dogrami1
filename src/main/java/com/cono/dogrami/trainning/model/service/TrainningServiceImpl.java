package com.cono.dogrami.trainning.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.trainning.model.dao.TrainningDao;
import com.cono.dogrami.trainning.model.vo.Trainning;

@Service("tranningService")
public class TrainningServiceImpl implements TrainningService {

	@Autowired
	private TrainningDao trainningDao;
	
	public ArrayList<Trainning> selectList() {	
		return trainningDao.selectList();
	}
}
