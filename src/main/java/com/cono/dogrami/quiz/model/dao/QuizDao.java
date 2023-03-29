package com.cono.dogrami.quiz.model.dao;

import org.springframework.stereotype.Repository;

import com.cono.dogrami.quiz.model.vo.Quiz;

@Repository("quizDao")
public class QuizDao {
	
	@Autowired // root-context.xml 에서 생성한 객체와 자동 연결
	private SqlSessionTemplate session;
	
	public int insertQuiz(Quiz quiz) {
		return session.insert("quizMapper.insertQuiz",quiz);
	}
	
	public int updateQuiz(Quiz quiz) {
		return session.update("quizMapper.updateQuiz",quiz);
	}
	
	public int deleteQuiz(Quiz quiz) {
		return session.delete("quizMapper.deleteQuiz",quiz);
	}
}
