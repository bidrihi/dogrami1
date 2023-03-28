package com.cono.dogrami.cafe.controller;

import com.cono.dogrami.cafe.model.service.CafeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class CafeController {
    private static final Logger logger = LoggerFactory.getLogger(CafeController.class);

    private CafeService cafeService;

}
