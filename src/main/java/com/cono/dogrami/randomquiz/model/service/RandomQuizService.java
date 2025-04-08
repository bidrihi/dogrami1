package com.cono.dogrami.randomquiz.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.randomquiz.model.vo.RandomQuiz;



public interface RandomQuizService {

	int rdselectListCount();
	int insertQuiz(RandomQuiz randomquiz);
	int updateQuiz(RandomQuiz randomquiz);
	int deleteQuiz(int rd_num);
	ArrayList<RandomQuiz> selectAll();
	RandomQuiz selectOne(String rd_quiz);
	RandomQuiz selectRandomQuiz(int rd_num);
	ArrayList<RandomQuiz> selectTitle(String keyword);
	ArrayList<RandomQuiz> startselectAll();
	ArrayList<RandomQuiz> selectSearch(Map<String, Object> params);
	int selectListCountSearch(Map<String, Object> params);
}
