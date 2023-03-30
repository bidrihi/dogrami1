package com.cono.dogrami.quiz.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cono.dogrami.quiz.model.service.QuizService;
import com.cono.dogrami.quiz.model.vo.Quiz;


@Controller  //xml에 클래스를 controller 로 자동 등록해 줌
public class QuizController {
	private static final Logger logger= LoggerFactory.getLogger(QuizController.class);
	
	@Autowired 
	private QuizService quizService;
	
	@RequestMapping(value="qinsert.do" , method=RequestMethod.POST)
	public String quizInsertMethod(Quiz quiz, Model model , HttpServletRequest request) {
		if(quizService.insertQuiz(quiz)>0) {
			//게시글 등록 성공시 목록으로1
			return "";
		}else {
			model.addAttribute("message","등록 실패!");
			return "common/error";
		}
	} // quizInsert

	@RequestMapping("qdel.do")
	public String quizDeleteMethod(Quiz quiz , Model model , HttpServletRequest request) {
		
		if(quizService.deleteQuiz(quiz)>0) {
			return "";
		}else {
			model.addAttribute("message",quiz.getQuiz_no()+ "번 글삭제 실패!");
			return "common/error";
		}
	}// quizDelete
	
	@RequestMapping(value ="qup.do" , method=RequestMethod.POST)
	public String quizUpdateMethod(Quiz quiz , Model model , HttpServletRequest request) {
		
		return  "";
	}


	@RequestMapping("qlist.do")
	public String quizListMethod(Model model) {
		ArrayList<Quiz> list = quizService.selectAll();
		
		if(list != null && list.size() >0) {
			model.addAttribute("list",list);
			return "quizboard/quizboard";
		}else {
			model.addAttribute("message","등록된 게시글이 없습니다.");
			return "common/error";
		}
		
	}//quizListMethod
	
	//공지글 상세보기 요청 처리용
		@RequestMapping("qdetail.do")
		public String noticeDetailMethod(
				@RequestParam("quiz_no") int quiz_no, 
				Model model, HttpSession session) {
				
			Quiz quiz = quizService.selectQuiz(quiz_no);
			
			if(quiz != null) {
				model.addAttribute("quiz", quiz);
				
					return "quizboard/quizDetailView";
				}
			else {
				model.addAttribute("message", 
						quiz_no + "번 공지글 상세보기 조회 실패!");
				return "common/error";
			}
		}
	
}//class
