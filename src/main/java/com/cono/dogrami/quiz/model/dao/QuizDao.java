package com.cono.dogrami.quiz.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.quiz.model.vo.Quiz;

@Repository("quizDao")
public class QuizDao {
	
	@Autowired // root-context.xml 에서 생성한 객체와 자동 연결
	private SqlSessionTemplate session;
	
	public int insertQuiz(Quiz quiz) {
//		return session.insert("quizMapper.insertQuiz",quiz);
	}
	
	public int updateQuiz(Quiz quiz) {
//		return session.update("quizMapper.updateQuiz",quiz);
	}
	
	public int deleteQuiz(Quiz quiz) {
//		return session.delete("quizMapper.deleteQuiz",quiz);
	}

	public ArrayList<Quiz> selectAll() {
		List<Quiz> list = session.selectList("quizMapper.selectAll");
		return (ArrayList<Quiz>)list;
	}

	public Quiz selectQuiz(int quiz_no) {
		
		return session.selectOne("quizMapper.selectQuiz",quiz_no);
	}
}
