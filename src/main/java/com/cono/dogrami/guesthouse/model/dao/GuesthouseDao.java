package com.cono.dogrami.guesthouse.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("guesthouseDao")
public class GuesthouseDao {
   
	@Autowired
    private SqlSessionTemplate session;
}
