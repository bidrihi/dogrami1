package com.cono.dogrami.diaryreply.model.service;

import com.cono.dogrami.diaryreply.model.dao.DiaryReplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("diaryReplyService")
public class DiaryReplyServiceImpl implements DiaryReplyService {
    @Autowired
    private DiaryReplyDao diaryReplyDao;
}
