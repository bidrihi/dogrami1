package com.cono.dogrami.randomquiz.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.randomquiz.model.vo.RandomQuiz;
@Repository("randomQuizDao")
public class RandomQuizDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public int insertQuiz(RandomQuiz randomquiz) {
//		return session.insert("quizMapper.insertQuiz",quiz);
	}

	public int updateQuiz(RandomQuiz randomquiz) {
//		return session.update("quizMapper.updateQuiz",quiz);
	}

	public int deleteQuiz(RandomQuiz randomquiz) {
//		return session.delete("quizMapper.deleteQuiz",quiz);
	}

	public ArrayList<RandomQuiz> selectAll() {
		List<RandomQuiz> list = session.selectList("randomQuizMapper.selectAll");
		return (ArrayList<RandomQuiz>)list;
	}

}
