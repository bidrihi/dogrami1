package com.cono.dogrami.hairshop.model.service;

import com.cono.dogrami.hairshop.model.dao.HairshopDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hairshopService")
public class HairshopServiceImpl implements HairshopService{
    @Autowired
    private HairshopDao hairshopDao;
}
