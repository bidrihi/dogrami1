package com.cono.dogrami.hospital.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("hospitalDao")
public class HospitalDao {
    @Autowired
    private SqlSessionTemplate session;
}
