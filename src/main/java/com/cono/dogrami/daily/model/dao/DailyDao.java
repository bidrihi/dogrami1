package com.cono.dogrami.daily.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dailyDao")
public class DailyDao {
    @Autowired
    private SqlSessionTemplate session;
}
