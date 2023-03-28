package com.cono.dogrami.dailyreply.model.service;

import com.cono.dogrami.dailyreply.model.dao.DailyReplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dailyReplyService")
public class DailyReplyServiceImpl implements DailyReplyService {
    @Autowired
    private DailyReplyDao dailyReplyDao;
}
