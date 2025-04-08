package com.cono.dogrami.notice.model.service;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.notice.model.vo.Notice;

import java.util.ArrayList;
import java.util.Map;

public interface NoticeService {
    ArrayList<Notice> selectList(Paging page); //한 페이지 출력할 공지 조회용
    Notice selectNotice(int notice_no); //해당 공지 번호에 대한 공지 상세 조회용
    int updateNoticeReadcount(int notice_no);   //상세보기시 조회수 1 증가
    int insertNotice(Notice notice);    //공지 등록
    ArrayList<Notice> selectSearch(Map<String, Object> params); //공지 검색
    int updateNotice(Notice notice);    //공지 수정
    int deleteNotice(int notice_no);    //공지 삭제
    int selectListCount();    //총 공지 갯수 조회용 (페이징 처리용)
    int selectListCountSearch(Map<String, Object> params); //공지 검색시 목록 갯수 처리용
    ArrayList<Notice> selectNewTop5();
}
