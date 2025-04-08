package com.cono.dogrami.notice.model.service;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.notice.model.dao.NoticeDao;
import com.cono.dogrami.notice.model.vo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    //공지 리스트
    @Override
    public ArrayList<Notice> selectList(Paging page) {
        return noticeDao.selectList(page);
    }

    //공지 검색
    @Override
    public Notice selectNotice(int notice_no) {
        return noticeDao.selectNotice(notice_no);
    }

    //공지 조회수 증가
    @Override
    public int updateNoticeReadcount(int notice_no) {
        return noticeDao.updateNoticeReadcount(notice_no);
    }

    //공지 목록 검색
    @Override
    public ArrayList<Notice> selectSearch(Map<String, Object> params) {
        return noticeDao.selectSearch(params);
    }

    //공지 검색시 목록 갯수
    @Override
    public int selectListCount() {
        return noticeDao.selectListCount();
    }

    //공지 삭제
    @Override
    public int deleteNotice(int notice_no) {
        return noticeDao.deleteNotice(notice_no);
    }

    //공지 작성
    @Override
    public int insertNotice(Notice notice) {
        return noticeDao.insertNotice(notice);
    }

    //공지 수정
    @Override
    public int updateNotice(Notice notice) {
        return noticeDao.updateNotice(notice);
    }

    //공지 검색
    @Override
    public int selectListCountSearch(Map<String, Object> params) {
        return noticeDao.selectListCountSearch(params);
    }

    //풋터 최신 공지 5개
    @Override
    public ArrayList<Notice> selectNewTop5() {
        return noticeDao.selectNewTop5();
    }
}
