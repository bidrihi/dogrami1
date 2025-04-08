package com.cono.dogrami.notice.model.dao;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.notice.model.vo.Notice;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("noticeDao")
public class NoticeDao {

    @Autowired
    private SqlSessionTemplate session;

    public ArrayList<Notice> selectList(Paging page) {
        List<Notice> list = session.selectList("noticeMapper.selectList", page);
        return (ArrayList<Notice>)list;
    }

    public Notice selectNotice(int notice_no) {
        return session.selectOne("noticeMapper.selectNotice",notice_no);
    }

    public int updateNoticeReadcount(int notice_no) {
        return session.update("noticeMapper.updateNoticeReadcount",notice_no);
    }

    public ArrayList<Notice> selectSearch(Map<String, Object> params) {
        List<Notice> list = session.selectList("noticeMapper.selectSearch", params);
        return (ArrayList<Notice>)list;
    }

    public int selectListCount() {
        return session.selectOne("noticeMapper.selectListCount");
    }

    public int insertNotice(Notice notice) {
        return session.insert("noticeMapper.insertNotice", notice);
    }

    public int updateNotice(Notice notice) {
        return session.update("noticeMapper.updateNotice", notice);
    }

    public int deleteNotice(int noticeNo) {
        return session.delete("noticeMapper.deleteNotice", noticeNo);
    }

    public int selectListCountSearch(Map<String, Object> params) {
        List<Notice> list = session.selectList("noticeMapper.selectListCountSearch", params);
        return list.size();
    }

    public ArrayList<Notice> selectNewTop5() {
        List<Notice> list = session.selectList("noticeMapper.selectNewTop5");
        return (ArrayList<Notice>)list;
    }
}
