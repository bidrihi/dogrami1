package com.cono.dogrami.trainning.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cono.dogrami.guesthouse.controller.GuesthouseController;
import com.cono.dogrami.trainning.model.service.TrainningService;
import com.cono.dogrami.trainning.model.vo.Trainning;

@Controller
public class TrainningController {
	private static final Logger logger = LoggerFactory.getLogger(TrainningController.class);
	@Autowired
	private TrainningService trainningService;
	
	@RequestMapping("trlist3.do")
	public String trainningListView(Model model) {
		ArrayList<Trainning> list = trainningService.selectList();
		
		if(list != null && list.size() > 0) {
			model.addAttribute("list", list);
			return "trainning/trainningListView";
		}else {
			model.addAttribute("error", "장소 정보가 존재하지않습니다.");
    		return "common/error";
		}
		
	}
	
}
