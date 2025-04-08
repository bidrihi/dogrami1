package com.cono.dogrami.hospital.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cono.dogrami.cafe.model.vo.Cafe;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.guesthouse.model.vo.Guesthouse;
import com.cono.dogrami.hospital.model.service.HospitalService;
import com.cono.dogrami.hospital.model.vo.Hospital;

@Controller
public class HospitalController {
	private static final Logger logger = LoggerFactory.getLogger(HospitalController.class);

	@Autowired
	private HospitalService hospitalService;
	
	//전체 리스트나열
	@RequestMapping(value="hospitalMap3.do", method = {RequestMethod.POST, RequestMethod.GET })
	public ModelAndView hospitalListView(ModelAndView mv,
			@RequestParam(name="page", required = false)String page) {
		int currentPage = 1;
		
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		int limit = 25;	//한페이지에 25개 출력
		
		int listCount = hospitalService.selectListCount(); //총갯수
		
		String url = "hospitalMap3.do";
		
		Paging paging = new Paging(listCount, currentPage, limit, url);
		
		paging.calculator();
		
		ArrayList<Hospital> list = hospitalService.selectList(paging);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.setViewName("hospital/hospitalListView");

		} else {
			mv.addObject("message", "장소 정보가 존재하지않습니다.");
			mv.setViewName("common/error");
		}
		return mv;
	}
	
	   //키워드로 받아서 리스트나열
    @RequestMapping(value="hospitalSearch3.do", method = RequestMethod.POST)
    public String hospitalSearchView(Model model,
    		@RequestParam("location") String location,
    		@RequestParam(value="page", required=false) String page){
    	
    	int currentPage = 1;	
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		int limit = 25;	//한페이지에 25개 출력
		
		int listCount = hospitalService.selectListCount(); //총갯수
		
		String url = "hospitalSearch3.do";
		
		Paging paging = new Paging(listCount, currentPage, limit, url);
		
		paging.calculator();
    	
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("location", location);
		
		listCount = hospitalService.selectListCountSearch(params);
		//총갯수 가져오고
		paging.setListCount(listCount);		
		paging.calculator();		
		params.put("paging", paging);
		
    	ArrayList<Hospital> list = hospitalService.selectSearchList(params);
    	
    	if(list != null && list.size() > 0) {
    		model.addAttribute("list", list);
    		model.addAttribute("location",location);		
			model.addAttribute("paging", paging);
			
    		return "hospital/hospitalListView";
    	}else {
    		model.addAttribute("message", "잘못 검색하신거나 조회하신 지역은 없습니다.");
    		return "common/error";
    	}
    	
    }
   
    	
    	
    

}