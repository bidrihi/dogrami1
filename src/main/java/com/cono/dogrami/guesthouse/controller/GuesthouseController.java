package com.cono.dogrami.guesthouse.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cono.dogrami.guesthouse.model.service.GuesthouseService;
import com.cono.dogrami.guesthouse.model.vo.Guesthouse;

@Controller
public class GuesthouseController {
    private static final Logger logger = LoggerFactory.getLogger(GuesthouseController.class);

    @Autowired
    private GuesthouseService guesthouseService;
    
    @RequestMapping("ghlist3.do")
    public String guesthouseListView(Model model) {
    	ArrayList<Guesthouse> list = guesthouseService.selectList();
    	
    	if(list != null && list.size() > 0) {
    		model.addAttribute("list", list);
    		return "guesthouse/guesthouseListView";
    	}else {
    		model.addAttribute("error", "장소 정보가 존재하지않습니다.");
    		return "common/error";
    	}
    }
}
