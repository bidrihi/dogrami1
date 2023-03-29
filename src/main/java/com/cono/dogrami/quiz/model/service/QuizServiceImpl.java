package com.cono.dogrami.quiz.model.service;

import org.springframework.stereotype.Service;

import com.cono.dogrami.quiz.model.dao.QuizDao;
import com.cono.dogrami.quiz.model.vo.Quiz;

@Service("quizService") //xml 자동 등록 처리됨
public class QuizServiceImpl implements QuizService {

	@Autowired  //dao 연결처리
	QuizDao quizDao;
	
	@Override
	public int insertQuiz(Quiz quiz) {
		return quizDao.insertQuiz(Quiz quiz);
	}

	@Override
	public int updateQuiz(Quiz quiz) {
		return quizDao.updateQuiz(Quiz quiz);
	}

	@Override
	public int deleteQuiz(Quiz quiz) {
		return quizDao.deleteQuiz(Quiz quiz);
	}
	
	
}
