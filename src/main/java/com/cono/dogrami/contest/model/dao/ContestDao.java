package com.cono.dogrami.contest.model.dao;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.contest.model.vo.Contest;
import com.cono.dogrami.contest.model.vo.ContestLike;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("contestDao")
public class ContestDao {
    @Autowired
    private SqlSessionTemplate session;

    public ArrayList<Contest> selectList(Paging page) {
        List<Contest> list = session.selectList("contestMapper.selectList", page);
        return (ArrayList<Contest>) list;
    }

    public Contest selectContestBoard(int contest_no) {
        return session.selectOne("contestMapper.selectContestBoard", contest_no);
    }

    public int updateContestBoardReadcount(int contest_no) {
        return session.update("contestMapper.updateContestBoardReadcount", contest_no);
    }

    public String selectnickname(int contest_no) {
        return session.selectOne("contestMapper.selectnickname", contest_no);
    }


    public int selectListCount() {
        return session.selectOne("contestMapper.selectListCount");
    }

    public int deleteContestBoard(int contest_no) {
        return session.delete("contestMapper.deleteContestBoard", contest_no);
    }

    public int insertContestBoard(Contest contest) {
        return session.insert("contestMapper.insertContestBoard", contest);
    }

    public int updateContestBoard(Contest contest) {
        return session.update("contestMapper.updateContestBoard", contest);
    }

    public int selectListCountSearch(String action, String keyword) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("action", action);
        params.put("keyword", keyword);
        List<Contest> list = session.selectList("contestMapper.selectListCountSearch", params);
        return list.size();
    }

    public ArrayList<Contest> selectSearch(String action, String keyword, Paging page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("action", action);
        params.put("keyword", keyword);
        params.put("page", page);
        List<Contest> list = session.selectList("contestMapper.selectSearch", params);
        return (ArrayList<Contest>) list;
    }

    public ContestLike selectLike(Contest contest) {
        return session.selectOne("contestMapper.selectLike", contest);
    }

    public void insertLike(Contest contest) {
        session.insert("contestMapper.insertLike", contest);

    }

    public void updateuLike(Contest contest) {
        session.update("contestMapper.updateuLike", contest);

    }

    public void updatedLike(Contest contest) {
        session.update("contestMapper.updatedLike", contest);

    }

    public void deleteLike(Contest contest) {
        session.delete("contestMapper.deleteLike", contest);

    }


    public ArrayList<Contest> selectTop5() {
        List<Contest> list = session.selectList("contestMapper.selectTop5");
        return (ArrayList<Contest>) list;
    }

    public ArrayList<Contest> selectNewTop5() {
        List<Contest> list = session.selectList("contestMapper.selectNewTop5");
        return (ArrayList<Contest>) list;
    }

    public int insertContestLike(Map<String, Object> params) {
        return session.insert("contestMapper.insertContestLike", params);

    }

    public int updateContestLikeCount(int contest_no) {
        return session.update("contestMapper.updateContestLikeCount", contest_no);

    }

    public int deleteContestLike(Map<String, Object> params) {
        return session.delete("contestMapper.deleteContestLike", params);

    }

    public ContestLike selectContestLikeCheck(Map<String, Object> params) {
        return session.selectOne("contestMapper.selectContestLikeCheck",params);
    }

}
