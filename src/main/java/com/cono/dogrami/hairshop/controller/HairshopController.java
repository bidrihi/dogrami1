package com.cono.dogrami.hairshop.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cono.dogrami.hairshop.model.service.HairshopService;
import com.cono.dogrami.hairshop.model.vo.Hairshop;

@Controller
public class HairshopController {
    private static final Logger logger = LoggerFactory.getLogger(HairshopController.class);

    @Autowired
    private HairshopService hairshopService;
    
    @RequestMapping("hairlist3.do")
    public String hairshopListView(Model model) {
    	ArrayList<Hairshop> list = hairshopService.selectList();
    	
    	if(list != null && list.size() > 0) {
    		model.addAttribute("list", list);
    		return "hairshop/hairshopListView";
    	}else {
    		model.addAttribute("error", "장소 정보가 존재하지않습니다.");
    		return "common/error";
    	}
    }
}
