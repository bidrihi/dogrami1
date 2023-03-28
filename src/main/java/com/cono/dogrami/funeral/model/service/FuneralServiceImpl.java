package com.cono.dogrami.funeral.model.service;

import com.cono.dogrami.funeral.model.dao.FuneralDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("funeralService")
public class FuneralServiceImpl implements FuneralService {
    @Autowired
    private FuneralDao funeralDao;
}
