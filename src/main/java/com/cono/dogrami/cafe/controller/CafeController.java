package com.cono.dogrami.cafe.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cono.dogrami.cafe.model.service.CafeService;
import com.cono.dogrami.cafe.model.vo.Cafe;

@Controller
public class CafeController {
    private static final Logger logger = LoggerFactory.getLogger(CafeController.class);

    @Autowired
    private CafeService cafeService;
    
    @RequestMapping("cafelist3.do")
    public String cafeListView(Model model) {
    	ArrayList<Cafe> list = cafeService.selectList();
    	
    	if(list != null && list.size() > 0) {
    		model.addAttribute("list", list);
    		return "cafe/cafeListView";
    	}else {
    		model.addAttribute("error", "장소 정보가 존재하지않습니다.");
    		return "common/error";
    	}
    }

}
