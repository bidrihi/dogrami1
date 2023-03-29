package com.cono.dogrami.guesthouse.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cono.dogrami.guesthouse.model.service.GuesthouseService;

@Controller
public class GuesthouseController {
    private static final Logger logger = LoggerFactory.getLogger(GuesthouseController.class);

    @Autowired
    private GuesthouseService guesthouseService;
}
