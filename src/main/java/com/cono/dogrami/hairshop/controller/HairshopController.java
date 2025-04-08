package com.cono.dogrami.hairshop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.hairshop.model.service.HairshopService;
import com.cono.dogrami.hairshop.model.vo.Hairshop;

@Controller
public class HairshopController {
    private static final Logger logger = LoggerFactory.getLogger(HairshopController.class);

    @Autowired
    private HairshopService hairshopService;
    
    //전체 리스트나열
    @RequestMapping(value="hairshopMap3.do", method = {RequestMethod.POST, RequestMethod.GET })
    public ModelAndView hairshopListView(ModelAndView mv,
    		@RequestParam(name = "page", required = false) String page) {
    	int currentPage = 1;
		
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		int limit = 25;	//한페이지에 25개 출력
		
		int listCount = hairshopService.selectListCount(); //총갯수
		
		String url = "hairshopMap3.do";
		
		Paging paging = new Paging(listCount, currentPage, limit, url);
		
		paging.calculator();
	
    	ArrayList<Hairshop> list = hairshopService.selectList(paging);
    	
    	if(list != null && list.size() > 0) {
    		mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.setViewName("hairshop/hairshopListView");
    		
    	}else {
    		mv.addObject("error", "장소 정보가 존재하지않습니다.");
			mv.setViewName("common/error");
		}
		return mv;
	}
    
    //키워드로 받아서 리스트나열
    @RequestMapping(value="hairshopSearch3.do", method = {RequestMethod.POST, RequestMethod.GET })
    public String hairshopSearchView(Model model,
    		@RequestParam("location") String location,
    		@RequestParam(value="page", required=false) String page) {
    	int currentPage = 1;
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		int limit = 25;	//한페이지에 25개 출력
			
		int listCount = hairshopService.selectListCount(); //총갯수
		
		String url = "hairshopSearch3.do";
		
		Paging paging = new Paging(listCount, currentPage, limit, url);
		
		paging.calculator();
		
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("location", location);
		
		listCount = hairshopService.selectListCountSearch(params);
		//총갯수 가져오고
		paging.setListCount(listCount);		
		paging.calculator();		
		params.put("paging", paging);
		
    	ArrayList<Hairshop> list = hairshopService.selectSearchList(params);
    	
    	if(list != null && list.size() > 0) {
    		model.addAttribute("list",list);
			model.addAttribute("location",location);		
			model.addAttribute("paging", paging);
			
    		return "hairshop/hairshopListView";
    	}else {
			model.addAttribute("message", "조회하신 " + location + " 은 없습니다.");
			return "common/error";
		}
    	
    }
   
    	
    	
    

}
