package com.cono.dogrami.hairshop.controller;

import com.cono.dogrami.hairshop.model.service.HairshopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HairshopController {
    private static final Logger logger = LoggerFactory.getLogger(HairshopController.class);

    @Autowired
    private HairshopService hairshopService;
}
