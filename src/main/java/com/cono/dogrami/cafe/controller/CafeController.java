package com.cono.dogrami.cafe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cono.dogrami.cafe.model.service.CafeService;
import com.cono.dogrami.cafe.model.vo.Cafe;
import com.cono.dogrami.common.Paging;

@Controller
public class CafeController {

	@Autowired
	private CafeService cafeService;
	
	//전체 리스트나열
	@RequestMapping(value="cafeMap3.do", method = {RequestMethod.POST, RequestMethod.GET })
	public ModelAndView cafeListView(ModelAndView mv,
			@RequestParam(name = "page", required = false) String page) {
		int currentPage = 1;
		
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		
		int limit = 25;	//한페이지에 25개 출력
		
		int listCount = cafeService.selectListCount(); //총갯수
		
		String url = "cafeMap3.do";
		
		Paging paging = new Paging(listCount, currentPage, limit, url);
		
		paging.calculator();
		
		ArrayList<Cafe> list = cafeService.selectList(paging);

		if (list != null && list.size() > 0) {
			mv.addObject("list", list);
			mv.addObject("paging", paging);
			mv.setViewName("cafe/cafeListView");
		} else {
			mv.addObject("error", "장소 정보가 존재하지않습니다.");
			mv.setViewName("common/error");
		}
		return mv;
	}
 
	//키워드로 받아서 리스트나열
    @RequestMapping(value="cafeSearch3.do", method = {RequestMethod.POST, RequestMethod.GET })
    public String guesthouseSearchView(Model model,
    		@RequestParam("location") String location,
    		@RequestParam(value="page", required=false) String page) {
    	int currentPage = 1;
		if(page != null) {
			currentPage = Integer.parseInt(page);
		}
		int limit = 25;	//한페이지에 25개 출력
			
		int listCount = cafeService.selectListCount(); //총갯수
		
		String url = "cafeSearch3.do";
		
		Paging paging = new Paging(listCount, currentPage, limit, url);
		
		paging.calculator();
		
		Map<String,Object> params = new HashMap<String,Object>();
		
		params.put("location", location);
		
		listCount = cafeService.selectListCountSearch(params);
		//총갯수 가져오고
		paging.setListCount(listCount);		
		paging.calculator();		
		params.put("paging", paging);
		
		ArrayList<Cafe> list = cafeService.selectSearchList(params);
		
		if(list != null && list.size() > 0) {
			model.addAttribute("list",list);
			model.addAttribute("location",location);		
			model.addAttribute("paging", paging);
			
			return "cafe/cafeListView";
		}else {
			model.addAttribute("message", "조회하신 " + location + " 은 없습니다.");
			return "common/error";
		}
    	
    }
}

