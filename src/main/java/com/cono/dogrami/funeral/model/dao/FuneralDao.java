package com.cono.dogrami.funeral.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("funeralDao")
public class FuneralDao {
    @Autowired
    private SqlSessionTemplate session;
}
