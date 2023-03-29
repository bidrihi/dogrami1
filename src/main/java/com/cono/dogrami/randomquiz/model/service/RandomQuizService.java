package com.cono.dogrami.randomquiz.model.service;

import java.util.ArrayList;

import com.cono.dogrami.randomquiz.model.vo.RandomQuiz;



public interface RandomQuizService {

	int insertQuiz(RandomQuiz randomquiz);
	int updateQuiz(RandomQuiz randomquiz);
	int deleteQuiz(RandomQuiz randomquiz);
	ArrayList<RandomQuiz> selectAll();
}
