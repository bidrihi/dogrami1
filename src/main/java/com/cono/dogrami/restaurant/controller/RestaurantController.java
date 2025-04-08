package com.cono.dogrami.restaurant.controller;

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
import com.cono.dogrami.restaurant.model.service.RestaurantService;
import com.cono.dogrami.restaurant.model.vo.Restaurant;

@Controller
public class RestaurantController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);
	
	@Autowired
	private RestaurantService restaurantService;
	
	//전체 리스트나열
	@RequestMapping(value="restaurantMap3.do",method = {RequestMethod.POST, RequestMethod.GET })
	public ModelAndView restaurantListView(ModelAndView mv,
			@RequestParam(name = "page", required = false) String page) {
		
		int currentPage = 1;
		
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		int limit = 25;	//한페이지에 25개 출력
		
		int listCount = restaurantService.selectListCount(); //총갯수
		
		String url = "restaurantMap3.do";
		
		Paging paging = new Paging(listCount, currentPage, limit, url);
		
		paging.calculator();
				
		ArrayList<Restaurant> list = restaurantService.selectList(paging);
		
    	if(list != null && list.size() > 0) {
    		mv.addObject("list", list);
    		mv.addObject("paging", paging);
    		mv.setViewName("restaurant/restaurantListView"); 		
    	}else {
    		mv.addObject("error", "장소 정보가 존재하지않습니다.");
			mv.setViewName("common/error");
    	}
    	return mv;
    }
	
	//키워드로 받아서 리스트나열
    @RequestMapping(value="restaurantSearch3.do", method = {RequestMethod.POST, RequestMethod.GET })
    public String guesthouseSearchView(Model model,
    		@RequestParam("location") String location,
    		@RequestParam(value="page", required=false) String page) {
    	int currentPage = 1;
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		int limit = 25;	//한페이지에 25개 출력
			
		int listCount = restaurantService.selectListCount(); //총갯수
		
		String url = "restaurantSearch3.do";
		
		Paging paging = new Paging(listCount, currentPage, limit, url);
		
		paging.calculator();
		
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("location", location);
    	
		listCount = restaurantService.selectListCountSearch(params);
		//총갯수 가져오고
		paging.setListCount(listCount);		
		paging.calculator();		
		params.put("paging", paging);
		
		
    	ArrayList<Restaurant> list = restaurantService.selectSearchList(params);
    	
    	if(list != null && list.size() > 0) {
    		model.addAttribute("list", list);
    		model.addAttribute("location",location);		
			model.addAttribute("paging", paging);
			
    		return "restaurant/restaurantListView";
    	}else {
    		model.addAttribute("message", "조회하신 " + location + " 은 없습니다.");
			return "common/error";
    	}
    	
    }
   
    	
    	
    

}

