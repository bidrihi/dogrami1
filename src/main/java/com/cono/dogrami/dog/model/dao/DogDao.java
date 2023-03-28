package com.cono.dogrami.dog.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.dog.model.vo.Dog;

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
}
