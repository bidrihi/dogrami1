package com.cono.dogrami.hotel.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("hotelDao")
public class HotelDao {
    @Autowired
    private SqlSessionTemplate session;
}
