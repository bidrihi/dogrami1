package com.cono.dogrami.careboard.controller;

import com.cono.dogrami.careboard.model.service.CareBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CareBoardController {
    private static final Logger logger = LoggerFactory.getLogger(CareBoardController.class);

    @Autowired
    private CareBoardService careBoardService;
}
