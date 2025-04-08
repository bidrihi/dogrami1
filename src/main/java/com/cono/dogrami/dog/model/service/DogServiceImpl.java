package com.cono.dogrami.dog.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.dog.model.dao.DogDao;
import com.cono.dogrami.dog.model.vo.Dog;

@Service("dogService")
public class DogServiceImpl implements DogService {
    @Autowired
    private DogDao dogDao;
    
    @Override
	public Dog selectDog(String dog_type) {
		return dogDao.selectDog(dog_type);
	}

	@Override
	public ArrayList<Dog> selectList() {
		return dogDao.selectList();
	}

	@Override
	public int insertDog(Dog dog) {
		return dogDao.insertDog(dog);
	}

	@Override
	public int updateDog(Dog dog) {
		return dogDao.updateDog(dog);
	}

	@Override
	public int deleteDog(Dog dog_type) {
		return dogDao.deleteDog(dog_type);
	}

	@Override
	public ArrayList<Dog> selectDogList(Dog dog) {
		
		return dogDao.selectDoglist(dog);
	}
}
