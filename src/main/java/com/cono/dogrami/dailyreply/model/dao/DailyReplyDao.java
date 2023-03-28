package com.cono.dogrami.dailyreply.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dailyReplyDao")
public class DailyReplyDao {
    @Autowired
    private SqlSessionTemplate session;
}
