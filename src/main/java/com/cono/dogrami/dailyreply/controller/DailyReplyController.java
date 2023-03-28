package com.cono.dogrami.dailyreply.controller;

import com.cono.dogrami.dailyreply.model.service.DailyReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DailyReplyController {
    private static final Logger logger = LoggerFactory.getLogger(DailyReplyController.class);

    @Autowired
    private DailyReplyService dailyReplyService;
}
