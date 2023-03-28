package com.cono.dogrami.guesthouse.controller;

import com.cono.dogrami.guesthouse.model.service.GuesthouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GuesthouseController {
    private static final Logger logger = LoggerFactory.getLogger(GuesthouseController.class);

    @Autowired
    private GuesthouseService guesthouseService;
}
