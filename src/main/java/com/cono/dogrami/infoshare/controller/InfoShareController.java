package com.cono.dogrami.infoshare.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cono.dogrami.daily.model.service.DailyService;
import com.cono.dogrami.infoshare.model.service.InfoShareService;

@Controller
public class InfoShareController {

	private static final Logger logger = LoggerFactory.getLogger(InfoShareController.class);
    
	@Autowired
    private InfoShareService infoShareService;
	
}
