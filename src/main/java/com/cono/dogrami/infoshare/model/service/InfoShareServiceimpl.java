package com.cono.dogrami.infoshare.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.infoshare.model.dao.InfoShareDao;
import com.cono.dogrami.infoshare.model.vo.InfoShare;

@Service("InfoShareService")
public class InfoShareServiceimpl implements InfoShareService{

	//의존성 주입
	@Autowired
	InfoShareDao infoshareDao;


	
	
	
}
