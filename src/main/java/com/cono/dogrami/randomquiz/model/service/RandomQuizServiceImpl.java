package com.cono.dogrami.randomquiz.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.randomquiz.model.dao.RandomQuizDao;
import com.cono.dogrami.randomquiz.model.vo.RandomQuiz;



@Service("RandomQuizService")
public class RandomQuizServiceImpl implements RandomQuizService{

	@Autowired
	RandomQuizDao randomQuizDao;
	
	@Override
	public int insertQuiz(RandomQuiz randomquiz) {
		return randomQuizDao.insertQuiz(randomquiz);
	}

	@Override
	public int updateQuiz(RandomQuiz randomquiz) {
		return randomQuizDao.updateQuiz(randomquiz);
	}

	@Override
	public int deleteQuiz(RandomQuiz randomquiz) {
		return randomQuizDao.deleteQuiz(randomquiz);
	}

	@Override
	public ArrayList<RandomQuiz> selectAll() {
		return randomQuizDao.selectAll();
	}
	


}
