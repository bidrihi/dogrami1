package com.cono.dogrami.hospital.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cono.dogrami.hospital.model.service.HospitalService;
import com.cono.dogrami.hospital.model.vo.Hospital;

@Controller
public class HospitalController {
    private static final Logger logger = LoggerFactory.getLogger(HospitalController.class);

    @Autowired
    private HospitalService hospitalService;
    
    @RequestMapping("hplist3.do")
    public String hospitalListView(Model model) {
    	ArrayList<Hospital> list = hospitalService.selectList();
    	
    	if(list != null && list.size() > 0) {
    		model.addAttribute("list", list);
    		return "hospital/hospitalListView";
    	}else {
    		model.addAttribute("error", "장소 정보가 존재하지않습니다.");
    		return "common/error";
    	}
    	
    	
    }
    
}
