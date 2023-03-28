package com.cono.dogrami.diary.controller;

import com.cono.dogrami.diary.model.service.DiaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DiaryController {
    private static final Logger logger = LoggerFactory.getLogger(DiaryController.class);

    @Autowired
    private DiaryService diaryService;
}
