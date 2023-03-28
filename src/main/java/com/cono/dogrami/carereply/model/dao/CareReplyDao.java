package com.cono.dogrami.carereply.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("careReplyDao")
public class CareReplyDao {

    @Autowired
    private SqlSessionTemplate session;
}
