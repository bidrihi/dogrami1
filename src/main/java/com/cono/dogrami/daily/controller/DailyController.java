package com.cono.dogrami.daily.controller;

import com.cono.dogrami.daily.model.service.DailyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DailyController {
    private static final Logger logger = LoggerFactory.getLogger(DailyController.class);

    @Autowired
    private DailyService dailyService;
    
	//게시글 전체 목록보기 요청 처리용

	
    
}