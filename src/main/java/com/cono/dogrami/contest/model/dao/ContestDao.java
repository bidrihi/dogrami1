package com.cono.dogrami.contest.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("contestDao")
public class ContestDao {
    @Autowired
    private SqlSessionTemplate session;
}
