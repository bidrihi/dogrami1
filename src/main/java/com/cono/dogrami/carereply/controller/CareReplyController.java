package com.cono.dogrami.carereply.controller;

import com.cono.dogrami.carereply.model.service.CareReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CareReplyController {
    private static final Logger logger = LoggerFactory.getLogger(CareReplyController.class);

    @Autowired
    private CareReplyService careReplyService;
}
