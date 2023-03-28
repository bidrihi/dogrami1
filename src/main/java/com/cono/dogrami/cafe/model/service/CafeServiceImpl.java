package com.cono.dogrami.cafe.model.service;

import com.cono.dogrami.cafe.model.dao.CafeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cafeService")
public class CafeServiceImpl implements CafeService {

    @Autowired
    private CafeDao cafeDao;
}
