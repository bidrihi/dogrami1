package com.cono.dogrami.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cono.dogrami.member.model.service.MemberService;
import com.cono.dogrami.member.model.vo.Member;


@Controller
public class MemberController {
	//이 컨트롤로 안의 메소드들이 구동되었는지 확인하는 로그를
		//출력하기 위한 로그 객체를 생성
		private static final Logger logger = 
				LoggerFactory.getLogger(MemberController.class);
		
	@Autowired  //자동 의존성주입(DI) : 자동 객체 생성됨
	private MemberService memberService;
	
//	//로그인 페이지 내보내기용 메소드
//	public String moveLoginPage() {}
//	
//	//회원가입 페이지 내보내기용
//	public String moveEnrollPage() {}
//	
//	//회원정보 수정페이지 내보내기용
//	public String moveUpdatePage(HttpServletRequest request, Model model) {}
//	
//	//로그인 처리용 메소드
//	public String loginMethod(Member member, 
//			HttpSession session, SessionStatus status, 
//			Model model) {}
//	
//	//ajax 통신으로 아이디 중복확인 요청 처리용 메소드
//	public void dupCheckIdMethod(
//			@RequestParam("userid") String userid, 
//			HttpServletResponse response) {}
//	
//	//회원가입 요청 처리용 메소드
//	public String memberInsertMethod(
//			Member member, Model model) {}
//	
//	//마이페이지 클릭시 내 정보 보기 요청 처리용 메소드
//	public ModelAndView memberDetailMethod(
//			@RequestParam("userid") String userid,
//			ModelAndView mv) {}
//	
//	//회원 탈퇴(삭제) 요청 처리용
//	public String memberDeleteMethod(
//			@RequestParam("userid") String userid, 
//			Model model) {}
//	
//	//회원정보 수정 처리용
//	public String memberUpdateMethod(Member member,
//			Model model) {}
//	
//	//회원관리용 회원전체목록 조회 처리용
//	public String memberListViewMethod(Model model) {}
//	
//	//관리자 기능 : 회원 로그인 제한/가능 처리용 메소드
//	public String changeLoginOKMethod(Member member, 
//			Model model) {}
//	
//	//회원 검색 처리용
//	public String memberSearchMethod(
//			HttpServletRequest request, Model model) {}
	
	
}
