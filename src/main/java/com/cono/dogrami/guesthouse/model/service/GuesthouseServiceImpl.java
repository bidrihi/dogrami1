package com.cono.dogrami.guesthouse.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.guesthouse.model.dao.GuesthouseDao;

@Service("guesthouseService")
public class GuesthouseServiceImpl implements GuesthouseService{
   
	@Autowired
    private GuesthouseDao guesthouseDao;
}
