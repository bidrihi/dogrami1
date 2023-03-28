package com.cono.dogrami.hospital.controller;

import com.cono.dogrami.hospital.model.service.HospitalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HospitalController {
    private static final Logger logger = LoggerFactory.getLogger(HospitalController.class);

    @Autowired
    private HospitalService hospitalService;
}
