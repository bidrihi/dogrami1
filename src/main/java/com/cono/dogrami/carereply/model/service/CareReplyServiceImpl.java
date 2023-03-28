package com.cono.dogrami.carereply.model.service;

import com.cono.dogrami.carereply.model.dao.CareReplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("careReplyService")
public class CareReplyServiceImpl implements CareReplyService {
    @Autowired
    private CareReplyDao careReplyDao;
}
