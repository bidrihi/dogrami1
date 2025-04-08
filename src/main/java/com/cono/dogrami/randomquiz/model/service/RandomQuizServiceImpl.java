package com.cono.dogrami.randomquiz.model.service;

import java.util.ArrayList;
import java.util.Map;

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
	public int deleteQuiz(int rd_num) {
		return randomQuizDao.deleteQuiz(rd_num);
	}

	@Override
	public ArrayList<RandomQuiz> selectAll() {
		return randomQuizDao.selectAll();
	}

	@Override
	public RandomQuiz selectOne(String rd_quiz) {
		
		return randomQuizDao.selectOne(rd_quiz);
	}

	@Override
	public RandomQuiz selectRandomQuiz(int rd_num) {
		
		return randomQuizDao.selectRandomQuiz(rd_num);
	}

	@Override
	public ArrayList<RandomQuiz> selectTitle(String keyword) {
		return randomQuizDao.selectTitle(keyword);
	}

	@Override
	public ArrayList<RandomQuiz> startselectAll() {
		
		return randomQuizDao.startselectAll();
	}

	@Override
	public ArrayList<RandomQuiz> selectSearch(Map<String, Object> params) {
		return randomQuizDao.selectSearch(params);
	}

	@Override
	public int selectListCountSearch(Map<String, Object> params) {
		return randomQuizDao.selectListCountSearch(params);
	}

	@Override
	public int rdselectListCount() {
		
		return randomQuizDao.rdselectListCount();
	}


	


}
