package com.cono.dogrami.funeral.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cono.dogrami.funeral.model.service.FuneralService;
import com.cono.dogrami.funeral.model.vo.Funeral;

@Controller
public class FuneralController {
    private static final Logger logger = LoggerFactory.getLogger(FuneralController.class);

    @Autowired
    private FuneralService funeralService;
    
    @RequestMapping("flist3.do")
    public String funeralListView(Model model) {
    	ArrayList<Funeral> list = funeralService.selectList();
    	
    	if(list != null && list.size() > 0) {
    	model.addAttribute("list", list);
    		return "funeral/funeralListView";
    	}else {
    		model.addAttribute("error", "장소 정보가 존재하지않습니다.");
    		return "common/error";
    	}
    }
}
