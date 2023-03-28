package com.cono.dogrami.diaryreply.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("diaryReplyDao")
public class DiaryReplyDao {
    @Autowired
    private SqlSessionTemplate session;
}
