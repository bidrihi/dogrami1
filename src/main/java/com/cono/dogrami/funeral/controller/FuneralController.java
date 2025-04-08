package com.cono.dogrami.funeral.controller;

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
import com.cono.dogrami.funeral.model.service.FuneralService;
import com.cono.dogrami.funeral.model.vo.Funeral;

@Controller
public class FuneralController {
    private static final Logger logger = LoggerFactory.getLogger(FuneralController.class);

    @Autowired
    private FuneralService funeralService;
    
    //전체 리스트 나열
    @RequestMapping(value="funeralMap3.do", method = {RequestMethod.POST, RequestMethod.GET })
    public ModelAndView funeralListView(ModelAndView mv,
    		@RequestParam(name = "page", required = false) String page) {	
    	int currentPage = 1;

		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		int limit = 25;	//한페이지에 25개 출력
		
		int listCount = funeralService.selectListCount(); //총갯수
		
		String url = "funeralMap3.do";
		
		Paging paging = new Paging(listCount, currentPage, limit, url);
		
		paging.calculator();
    	  	
    	ArrayList<Funeral> list = funeralService.selectList(paging);
   	   	
    	if(list != null && list.size() > 0) {
    		mv.addObject("list", list);
    		mv.setViewName("funeral/funeralListView");
    	}else {
    		mv.addObject("error", "장소 정보가 존재하지않습니다.");
    		mv.setViewName( "common/error");
    	}	
    	return mv;
    }
    
  //키워드로 받아서 리스트나열
    @RequestMapping(value="funeralSearch3.do", method = RequestMethod.POST)
    public String guesthouseSearchView(Model model,
    		@RequestParam("location") String location,
    		@RequestParam(value="page", required=false) String page) {    	
    	int currentPage = 1;
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		int limit = 25;	//한페이지에 25개 출력
			
		int listCount = funeralService.selectListCount(); //총갯수
		
		String url = "funeralSearch3.do";
		
		Paging paging = new Paging(listCount, currentPage, limit, url);
		
		paging.calculator();
		
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("location", location);
		
		listCount = funeralService.selectListCountSearch(params);
		//총갯수 가져오고
		paging.setListCount(listCount);		
		paging.calculator();		
		params.put("paging", paging);
			   	
    	ArrayList<Funeral> list = funeralService.selectSearchList(params);
    	
    	if(list != null && list.size() > 0) {
    		model.addAttribute("list", list);
    		model.addAttribute("location",location);		
			model.addAttribute("paging", paging);
			
    		return "funeral/funeralListView";
    	}else {
    		model.addAttribute("message", "조회하신 " + location + " 은 없습니다.");
    		return "common/error";
    	}
    	
    }
}

