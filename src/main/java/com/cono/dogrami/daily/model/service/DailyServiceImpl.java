package com.cono.dogrami.daily.model.service;

import com.cono.dogrami.daily.model.dao.DailyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dailyService")
public class DailyServiceImpl implements DailyService{
    @Autowired
    private DailyDao dailyDao;
}
