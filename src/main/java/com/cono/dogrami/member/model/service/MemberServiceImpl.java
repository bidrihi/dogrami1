package com.cono.dogrami.member.model.service;

import com.cono.dogrami.careboard.model.vo.CareBoard;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.daily.model.vo.Daily;
import com.cono.dogrami.diary.model.vo.Diary;
import com.cono.dogrami.member.model.dao.MemberDao;
import com.cono.dogrami.member.model.vo.Member;
import com.cono.dogrami.placeboard.model.vo.PlaceBoard;
import com.cono.dogrami.question.model.vo.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;


@Service("MemberService")
public class MemberServiceImpl implements MemberService {
    //DAO 와 연결 처리
    @Autowired    //자동 DI 처리됨 : 자동 객체 생성됨
    MemberDao memberDao;

    @Override
    public Member selectLogin(Member member) {
        return memberDao.selectLogin(member);
    }

    @Override
    public int selectDupCheckId(String user_id) {
        return memberDao.selectDupCheckId(user_id);
    }

    @Override
    public Member selectMember(String user_id) {
        return memberDao.selectMember(user_id);
    }

    @Override
    public ArrayList<Member> selectList(Paging page) {
        return memberDao.selectList(page);
    }

    @Override
    public int insertMember(Member member) {
        return memberDao.insertMember(member);
    }

    @Override
    public int updateMember(Member member) {
        return memberDao.updateMember(member);
    }

    @Override
    public int updateLoginLimit(Member member) {
        return memberDao.updateLoginLimit(member);
    }

    @Override
    public int deleteMember(String user_id) {
        return memberDao.deleteMember(user_id);
    }

    @Override
    public ArrayList<Member> selectSearchUserid(String keyword) {
        return memberDao.selectSearchUserid(keyword);
    }

    @Override
    public ArrayList<Member> selectSearchUsernick(String keyword) {
        return memberDao.selectSearchUsernick(keyword);
    }

    @Override
    public ArrayList<Member> selectSearchUsername(String keyword) {
        return memberDao.selectSearchUsername(keyword);
    }

    @Override
    public ArrayList<Member> selectSearchLoginLimit(String keyword) {
        return memberDao.selectSearchLoginLimit(keyword);
    }

    @Override
    public ArrayList<Member> selectSearchUserAdmin(String keyword) {
        return memberDao.selectSearchUserAdmin(keyword);
    }

    @Override
    public int updateUserAdmin(Member member) {
        return memberDao.updateUserAdmin(member);
    }

    // 내가 쓴글 목록
    @Override
    public ArrayList<Daily> selectMyDailyBoardList(String user_id) {
        return memberDao.selectMyDailyBoardList(user_id);
    }

    @Override
    public ArrayList<Diary> selectMyDiaryBoardList(String user_id) {
        return memberDao.selectMyDiaryBoardList(user_id);
    }

    @Override
    public ArrayList<CareBoard> selectMyCareBoardList(String user_id) {
        return memberDao.selectMyCareBoardList(user_id);
    }

    @Override
    public ArrayList<PlaceBoard> selectMyPlaceBoardList(String user_id) {
        return memberDao.selectMyPlaceBoardList(user_id);
    }

    @Override
    public ArrayList<Question> selectMyQuestionBoardList(String user_id) {
        return memberDao.selectMyQuestionBoardList(user_id);
    }

    @Override
    public int updatepw(Member member) {
        return memberDao.updatepw(member);
    }

    @Override
    public int selectListCount() {
        return memberDao.selectListCount();
    }

    @Override
    public int selectListCountSearch(Map<String, Object> params) {
        return memberDao.selectListCountSearch(params);
    }

    @Override
    public ArrayList<Member> selectSearch(Map<String, Object> params) {
        return memberDao.selectSearch(params);
    }
}
