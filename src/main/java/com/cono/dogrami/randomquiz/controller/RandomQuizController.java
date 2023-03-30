package com.cono.dogrami.randomquiz.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cono.dogrami.randomquiz.model.service.RandomQuizService;
import com.cono.dogrami.randomquiz.model.vo.RandomQuiz;

@Controller
public class RandomQuizController {
	private static final Logger logger= LoggerFactory.getLogger(RandomQuizController.class);
	
	@Autowired
	private RandomQuizService randomQuizService;
	
	@RequestMapping("rdlist.do")
	public String quizListMethod(Model model) {
		ArrayList<RandomQuiz> list = randomQuizService.selectAll();
		
		if(list != null && list.size() >0) {
			model.addAttribute("list",list);
			return "randomquiz/adminrandomquiz";
		}else {
			model.addAttribute("message","등록된 게시글이 없습니다.");
			return "common/error";
		}
		
	}//quizListMethod
}
