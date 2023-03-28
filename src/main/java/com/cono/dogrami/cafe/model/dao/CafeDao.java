package com.cono.dogrami.cafe.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("cafeDao")
public class CafeDao {

    @Autowired
    private SqlSessionTemplate session;
}
