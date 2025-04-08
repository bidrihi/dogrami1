package com.cono.dogrami.randomquiz.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.randomquiz.model.vo.RandomQuiz;
@Repository("randomQuizDao")
public class RandomQuizDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public int insertQuiz(RandomQuiz randomquiz) {
	return session.insert("randomQuizMapper.insertQuiz",randomquiz);
	}

	public int updateQuiz(RandomQuiz randomquiz) {
		
		return session.update("randomQuizMapper.updateQuiz",randomquiz);
	}

	public int deleteQuiz(int rd_num) {
	return session.delete("randomQuizMapper.deleteQuiz",rd_num);
	}

	public ArrayList<RandomQuiz> selectAll() {
		List<RandomQuiz> list = session.selectList("randomQuizMapper.selectAll");
		return (ArrayList<RandomQuiz>)list;
	}

	public RandomQuiz selectOne(String rd_quiz) {
	
		return	session.selectOne("randomQuizMapper.selectOne",rd_quiz);
	}

	public RandomQuiz selectRandomQuiz(int rd_num) {
	
		return session.selectOne("randomQuizMapper.selectRandomQuiz",rd_num);
	}

	public ArrayList<RandomQuiz> selectTitle(String keyword) {
			List<RandomQuiz> list = session.selectList("randomQuizMapper.selectTitle",keyword);
		return (ArrayList<RandomQuiz>)list;
	}

	

	public ArrayList<RandomQuiz> startselectAll() {
		List<RandomQuiz> list = session.selectList("randomQuizMapper.startselectAll");
		return (ArrayList<RandomQuiz>)list;
	}

	public int rdselectListCount() {
		
		return session.selectOne("randomQuizMapper.rdselectListCount");
	}

	public ArrayList<RandomQuiz> selectSearch(Map<String, Object> params) {
		List<RandomQuiz> list = session.selectList("randomQuizMapper.selectSearch", params);
		return (ArrayList<RandomQuiz>)list;
	}

	public int selectListCountSearch(Map<String, Object> params) {
		List<RandomQuiz> list = session.selectList("randomQuizMapper.selectSearch", params);
		return list.size();
	}
}
