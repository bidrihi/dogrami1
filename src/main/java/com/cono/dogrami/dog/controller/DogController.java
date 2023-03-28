package com.cono.dogrami.dog.controller;

import com.cono.dogrami.dog.model.service.DogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DogController {
    private static final Logger logger = LoggerFactory.getLogger(DogController.class);

    @Autowired
    private DogService dogService;
}
