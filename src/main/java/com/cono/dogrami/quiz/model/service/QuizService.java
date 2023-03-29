package com.cono.dogrami.quiz.model.service;

import java.util.ArrayList;

import com.cono.dogrami.quiz.model.vo.Quiz;

public interface QuizService {
	int insertQuiz(Quiz quiz);
	int updateQuiz(Quiz quiz);
	int deleteQuiz(Quiz quiz);
	ArrayList<Quiz> selectAll();
	Quiz selectQuiz(int quiz_no);
}
