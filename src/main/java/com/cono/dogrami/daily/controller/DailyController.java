package com.cono.dogrami.daily.controller;

import com.cono.dogrami.daily.model.service.DailyService;
import com.cono.dogrami.daily.model.vo.Daily;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DailyController {
    private static final Logger logger = LoggerFactory.getLogger(DailyController.class);

    @Autowired
    private DailyService dailyService;
    
    
	//게시글 전체 목록보기 요청 처리용
	@RequestMapping("dailyboardlist.do")
	public String dailyboardListMethod(Model model) {
		ArrayList<Daily> list = dailyService.selectList();
		
		if(list != null && list.size() > 0) {
			model.addAttribute("list", list);
			return "board/dailyboardListView";
		}else {
			model.addAttribute("message", 
					"등록된 게시글 정보가 없습니다...;");
			return "common/error";
		}
	}
    
    
    
    
    
    
}
