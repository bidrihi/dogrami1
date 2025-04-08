package com.cono.dogrami.dog.model.service;

import java.util.ArrayList;

import com.cono.dogrami.dog.model.vo.Dog;

public interface DogService {
	Dog selectDog(String dog_type);
	ArrayList<Dog> selectList();
	int insertDog(Dog dog);
	int updateDog(Dog dog);
	int deleteDog(Dog dog_type);
	ArrayList<Dog> selectDogList(Dog dog);
}
