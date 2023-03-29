package com.cono.dogrami.cafe.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.cafe.model.vo.Cafe;

@Repository("cafeDao")
public class CafeDao {

    @Autowired
    private SqlSessionTemplate session;

	public ArrayList<Cafe> selectList() {
		List<Cafe> list = session.selectList("cafeMapper.selectList");
		return (ArrayList<Cafe>)list;
	}
}
