package com.cono.dogrami.dog.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cono.dogrami.dog.model.service.DogService;
import com.cono.dogrami.dog.model.vo.Dog;
import com.cono.dogrami.randomquiz.model.vo.RandomQuiz;

@Controller
public class DogController {
	private static final Logger logger = LoggerFactory.getLogger(DogController.class);

	@Autowired
	private DogService dogService;

//	 성향테스트 페이지 내보내기용
	@RequestMapping("doglist.do")
	public String moveTestPage() {
		return "dogtest/dogtest";
	}
	
	@RequestMapping(value="dogresult.do" , method = RequestMethod.POST)
	public String dogTest(Dog dog , Model model) {
		
		ArrayList<Dog> list =dogService.selectDogList(dog);
		
		if(list != null  && list.size() > 0 ) {
			model.addAttribute("list",list);
			
			return "dogtest/dogresult";
		}else {
			
			return "dogtest/dognresult";
		}
		
	}
	
	
	

//	// 품종 수정페이지 내보내기용
//	public String moveDogUpdatePage(@RequestParam("dog_type") String dog_type, Model model) {
//	}
//
//	// 품종 추가용 메소드
//	public String dogInsertMethod(Dog dog, Model model) {
//	}
//
//	// 품종 삭제용 메소드
//	public String dogDeleteMethod(@RequestParam("dog_type") String dog_type, Model model) {
//	}
//
//	// 품종 수정 처리용 메소드
//	public String dogUpdateMethod(Dog dog, Model model) {
//	}
//
//	// 품종 전체목록 조회 처리용
//	public String dogListViewMethod(Dog dog) {
//	}
//
//	// 품종 검색 처리용
//	public String dogSearchMethod(HttpServletRequest request, Model model) {
//	}
}
