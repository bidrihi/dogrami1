package com.cono.dogrami.contest.controller;

import com.cono.dogrami.contest.model.service.ContestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ContestController {
    private static final Logger logger = LoggerFactory.getLogger(ContestController.class);

    @Autowired
    private ContestService contestService;
}
