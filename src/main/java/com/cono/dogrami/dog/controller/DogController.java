package com.cono.dogrami.dog.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.cono.dogrami.dog.model.service.DogService;
import com.cono.dogrami.dog.model.vo.Dog;

@Controller
public class DogController {
	private static final Logger logger = LoggerFactory.getLogger(DogController.class);

	@Autowired
	private DogService dogService;

	// 성향테스트 페이지 내보내기용
//	public String moveTestPage() {
//	}
//
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
