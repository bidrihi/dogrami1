package com.cono.dogrami.hairshop.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("hairshopDao")
public class HairshopDao {
    @Autowired
    private SqlSessionTemplate session;
}
