package com.cono.dogrami.quiz.model.service;

import com.cono.dogrami.quiz.model.vo.Quiz;

public interface QuizService {
	int insertQuiz(Quiz quiz);
	int updateQuiz(Quiz quiz);
	int deleteQuiz(Quiz quiz);
}
