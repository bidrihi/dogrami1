package com.cono.dogrami.funeral.controller;

import com.cono.dogrami.funeral.model.service.FuneralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FuneralController {
    private static final Logger logger = LoggerFactory.getLogger(FuneralController.class);

    @Autowired
    private FuneralService funeralService;
}
