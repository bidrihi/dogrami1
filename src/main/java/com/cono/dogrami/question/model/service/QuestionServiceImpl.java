package com.cono.dogrami.question.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.daily.model.dao.DailyDao;
import com.cono.dogrami.question.model.dao.QuestionDao;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionDao questionDao;
}
