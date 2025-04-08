package com.cono.dogrami.randomquiz.controller;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.randomquiz.model.service.RandomQuizService;
import com.cono.dogrami.randomquiz.model.vo.RandomQuiz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RandomQuizController {
    private static final Logger logger = LoggerFactory.getLogger(RandomQuizController.class);

    @Autowired
    private RandomQuizService randomQuizService;

    //랜덤퀴즈 관리자용 / 일반회원 게시판
    @RequestMapping("rdlist.do")
    public String quizListMethod(Model model) {

        ArrayList<RandomQuiz> list = randomQuizService.selectAll();

        model.addAttribute("list", list);

        return "randomquiz/adminrandomquiz";
    }//quizListMethod

    //상세보기 페이지
    @RequestMapping("rddetail.do")
    public ModelAndView rdDetailMethod(ModelAndView mv, @RequestParam("rd_quiz") String rd_quiz) {

        RandomQuiz randomquiz = randomQuizService.selectOne(rd_quiz);

        if (randomquiz != null) {
            mv.addObject("randomquiz", randomquiz);


            mv.setViewName("randomquiz/randomquizdetail");
        } else {
            mv.addObject("message", "문제 조회 실패!");
            mv.setViewName("common/error");
        }

        return mv;
    }//rdDetailMethod


    //랜덤퀴즈 글쓰기 페이지 이동용 (관리자)
    @RequestMapping("moverdquiz.do")
    public String moverdQuiz() {
        return "randomquiz/quizinsert";
    }

    //랜덤퀴즈 등록 요청 처리(관리자)
    @RequestMapping(value = "rdqinsert.do", method = RequestMethod.POST)
    public String rdquizInsert(RandomQuiz randomquiz, Model model, HttpServletRequest request) {

        if (randomQuizService.insertQuiz(randomquiz) > 0) {
            return "redirect:rdlist.do";
        } else {
            model.addAttribute("message", "퀴즈 등록 실패 !");
            return "common/error";
        }
    }//rdquizInsert


    //퀴즈 문제 수정 처리 (관리자)
    @RequestMapping(value = "upquiz.do", method = RequestMethod.POST)
    public String upquiz(RandomQuiz randomquiz, Model model, HttpServletRequest request) {

        if (randomQuizService.updateQuiz(randomquiz) > 0) {
            // 게시원글 수정 성공시 상세보기 페이지로 이동
            model.addAttribute("rd_num", randomquiz.getRd_num());
            return "redirect:rdlist.do";
        } else {
            model.addAttribute("message", "문제 수정 실패!");
            return "common/error";
        }
    }//upquiz

    //수정페이지 이동처리
    @RequestMapping(value = "moverdupquiz.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String moverdupquizMethod(@RequestParam("rd_num") String rd_num, Model model) {


        RandomQuiz randomquiz = randomQuizService.selectRandomQuiz(Integer.parseInt(rd_num));

        if (randomQuizService.updateQuiz(randomquiz) > 0) {

            model.addAttribute("randomquiz", randomquiz);
            return "randomquiz/quizupdate";
        } else {
            model.addAttribute("message", "문제 수정 실패!");
            return "common/error";
        }
    }//moverdupquizMethod

    //삭제처리용 메소드
    @RequestMapping(value = "delete.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String deleteQuizMethod(@RequestParam("rd_num") int rd_num, Model model) {

        if (randomQuizService.deleteQuiz(rd_num) > 0) {
            return "redirect:rdlist.do";
        } else {
            model.addAttribute("message", "삭제 실패!");
            return "common/error";
        }
    }

    //검색처리용
    @RequestMapping(value = "rdsearch.do", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView rdSearchMethod( @RequestParam("action") String action,
                                  @RequestParam(name = "page", required = false) String page,
                                  @RequestParam("keyword") String keyword,
                                  ModelAndView mv) {

        ArrayList<RandomQuiz> list = null;
        int currentPage = 1;

        if (page != null) {
            currentPage = Integer.parseInt(page);
        }

        int limit = 10;
        int listCount = 0;

        String url = "rdsearch.do";
        Paging paging = new Paging(listCount, currentPage, limit, url);

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("action", action);
        params.put("keyword", keyword);

        listCount = randomQuizService.selectListCountSearch(params);
        paging.setListCount(listCount);
        paging.calculator();
        params.put("paging", paging);
        list = randomQuizService.selectSearch(params);

        if (list != null && list.size() > 0) {
            mv.addObject("list", list);
            mv.addObject("action", action);
            mv.addObject("keyword", keyword);
            mv.addObject("paging", paging);
            mv.setViewName("randomquiz/adminrandomquiz");
        } else {
            mv.addObject("message", keyword + "로 검색된 게시글 정보가 없습니다.");
            mv.setViewName("common/error");
        }

        return mv;

    }// rdSearchMethod


    //랜덤퀴즈게임 start 메소드
    @RequestMapping("movegame.do")
    public String movegameMethod(Model model) {
        ArrayList<RandomQuiz> list = randomQuizService.startselectAll();

        model.addAttribute("list", list);
        return "randomquiz/quizstart";


    }//movegameMethod

    //정답화면이동
    @RequestMapping("answer.do")
    public String moveanswerMethod(@RequestParam("rd_quiz") String rd_quiz, @RequestParam("rd_explain") String rd_explain
            , Model model) {

        RandomQuiz randomquiz = new RandomQuiz(rd_quiz, rd_explain);

        model.addAttribute("randomquiz", randomquiz);


        return "randomquiz/randomanswer";
    }//moveanswerMethod


    //오답화면이동
    @RequestMapping("nanswer.do")
    public String movenanswerMethod(@RequestParam("rd_quiz") String rd_quiz, @RequestParam("rd_explain") String rd_explain
            , Model model) {

        RandomQuiz randomquiz = new RandomQuiz(rd_quiz, rd_explain);

        model.addAttribute("randomquiz", randomquiz);


        return "randomquiz/randomnanswer";
    }//movenanswerMethod

}
