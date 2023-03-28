package com.cono.dogrami.careboard.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("careBoardDao")
public class CareBoardDao {

    @Autowired
    private SqlSessionTemplate session;
}
