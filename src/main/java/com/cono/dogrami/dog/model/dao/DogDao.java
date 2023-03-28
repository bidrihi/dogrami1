package com.cono.dogrami.dog.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dogDao")
public class DogDao {
    @Autowired
    private SqlSessionTemplate session;
}
