package com.cono.dogrami.careboard.model.service;

import com.cono.dogrami.careboard.model.dao.CareBoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("careBoardService")
public class CareBoardServiceImpl implements CareBoardService {

    @Autowired
    private CareBoardDao careBoardDao;
}
