package com.cono.dogrami.quiz.controller;

import com.cono.dogrami.quiz.model.service.QuizService;
import com.cono.dogrami.quiz.model.vo.Quiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller  //xml에 클래스를 controller 로 자동 등록해 줌
public class QuizController {
    private static final Logger logger = LoggerFactory.getLogger(QuizController.class);

    @Autowired
    private QuizService quizService;

    @RequestMapping(value = "qinsert.do", method = RequestMethod.POST)
    public String quizInsertMethod(Quiz quiz, Model model, HttpServletRequest request) {
        if (quizService.insertQuiz(quiz) > 0) {
            //게시글 등록 성공시 목록으로
            return "";
        } else {
            model.addAttribute("message", "등록 실패!");
            return "common/error";
        }
    } // quizInsert

    @RequestMapping("qdel.do")
    public String quizDeleteMethod(Quiz quiz, Model model, HttpServletRequest request) {

        if (quizService.deleteQuiz(quiz) > 0) {
            return "";
        } else {
            model.addAttribute("message", quiz.getQuiz_no() + "번 글삭제 실패!");
            return "common/error";
        }
    }// quizDelete

    @RequestMapping(value = "qup.do", method = RequestMethod.POST)
    public String quizUpdateMethod(Quiz quiz, Model model, HttpServletRequest request) {
        return null;
    }

}//class
