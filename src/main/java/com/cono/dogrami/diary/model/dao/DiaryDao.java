package com.cono.dogrami.diary.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("diaryDao")
public class DiaryDao {
    @Autowired
    private SqlSessionTemplate session;
}
