package com.cono.dogrami.dog.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.dog.model.vo.Dog;
import com.cono.dogrami.randomquiz.model.vo.RandomQuiz;

@Repository("dogDao")
public class DogDao {
   
	@Autowired
    private SqlSessionTemplate session;
    
    public Dog selectDog(String dog_type) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Dog> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertDog(Dog dog) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateDog(Dog dog) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteDog(Dog dog_type) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Dog> selectDoglist(Dog dog) {
		List<Dog> list = session.selectList("dogMapper.selectDoglist",dog);
		return (ArrayList<Dog>)list;
	}
}
