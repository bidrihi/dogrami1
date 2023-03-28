package com.cono.dogrami.diaryreply.controller;

import com.cono.dogrami.diaryreply.model.service.DiaryReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DiaryReplyController {
    private static final Logger logger = LoggerFactory.getLogger(DiaryReplyController.class);

    @Autowired
    private DiaryReplyService diaryReplyService;
}
