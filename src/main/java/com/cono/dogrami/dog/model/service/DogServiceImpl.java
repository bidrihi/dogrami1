package com.cono.dogrami.dog.model.service;

import com.cono.dogrami.dog.model.dao.DogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dogService")
public class DogServiceImpl implements DogService {
    @Autowired
    private DogDao dogDao;
}
