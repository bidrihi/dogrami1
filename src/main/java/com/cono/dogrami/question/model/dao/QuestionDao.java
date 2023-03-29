package com.cono.dogrami.question.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("questionDao")
public class QuestionDao {

    @Autowired
    private SqlSessionTemplate session;
    
}
