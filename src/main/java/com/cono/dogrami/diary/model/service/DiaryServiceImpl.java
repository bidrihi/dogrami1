package com.cono.dogrami.diary.model.service;

import com.cono.dogrami.diary.model.dao.DiaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("diaryService")
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    private DiaryDao diaryDao;
}
