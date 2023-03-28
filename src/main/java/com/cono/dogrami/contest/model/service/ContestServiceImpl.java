package com.cono.dogrami.contest.model.service;

import com.cono.dogrami.contest.model.dao.ContestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("contestService")
public class ContestServiceImpl implements ContestService {
    @Autowired
    private ContestDao contestDao;
}
