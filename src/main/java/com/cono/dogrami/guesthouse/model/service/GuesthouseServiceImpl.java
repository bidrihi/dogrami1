package com.cono.dogrami.guesthouse.model.service;

import com.cono.dogrami.guesthouse.model.dao.GuesthouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("guesthouseService")
public class GuesthouseServiceImpl implements GuesthouseService {
    @Autowired
    private GuesthouseDao guesthouseDao;
}
