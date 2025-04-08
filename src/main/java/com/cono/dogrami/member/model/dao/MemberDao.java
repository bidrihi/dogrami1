package com.cono.dogrami.member.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cono.dogrami.common.Paging;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.careboard.model.vo.CareBoard;
import com.cono.dogrami.daily.model.vo.Daily;
import com.cono.dogrami.diary.model.vo.Diary;
import com.cono.dogrami.member.model.vo.Member;
import com.cono.dogrami.placeboard.model.vo.PlaceBoard;
import com.cono.dogrami.question.model.vo.Question;

@Repository("MemberDao")
public class MemberDao {
	@Autowired // root-context.xml 에서 생성한 객체와 자동 연결
	private SqlSessionTemplate session; // 의존성 주입됨(DI)

	public Member selectLogin(Member member) {
		return session.selectOne("memberMapper.selectLogin", member);
	}

	public int selectDupCheckId(String user_id) {
		return session.selectOne("memberMapper.selectDupCheckId", user_id);
	}

	public Member selectMember(String user_id) {
		return session.selectOne("memberMapper.selectMember1", user_id);
	}

	public ArrayList<Member> selectList(Paging page) {
		List<Member> list = session.selectList("memberMapper.selectList", page);
		return (ArrayList<Member>)list;
	}

	public int insertMember(Member member) {
		return session.insert("memberMapper.insertMember", member);
	}

	public int updateMember(Member member) {
		return session.update("memberMapper.updateMember", member);
	}

	public int updateLoginLimit(Member member) {
		return session.update("memberMapper.updateLoginLimit", member);
	}

	public int deleteMember(String user_id) {
		return session.delete("memberMapper.deleteMember", user_id);
	}

	public ArrayList<Member> selectSearchUserid(String keyword) {
		List<Member> list = session.selectList("memberMapper.selectSearchUserid", keyword);
		return (ArrayList<Member>) list;
	}

	public ArrayList<Member> selectSearchUsernick(String keyword) {
		List<Member> list = session.selectList("memberMapper.selectSearchUsernick", keyword);
		return (ArrayList<Member>) list;
	}

	public ArrayList<Member> selectSearchUsername(String keyword) {
		List<Member> list = session.selectList("memberMapper.selectSearchUsername", keyword);
		return (ArrayList<Member>) list;
	}

	public ArrayList<Member> selectSearchLoginLimit(String keyword) {
		List<Member> list = session.selectList("memberMapper.selectSearchLoginLimit", keyword);
		return (ArrayList<Member>) list;
	}

	public ArrayList<Member> selectSearchUserAdmin(String keyword) {
		List<Member> list = session.selectList("memberMapper.selectSearchUserAdmin", keyword);
		return (ArrayList<Member>) list;
	}

	public int updateUserAdmin(Member member) {
		return session.update("memberMapper.updateUserAdmin", member);
	}
	
	public ArrayList<Daily> selectMyDailyBoardList(String user_id){
		List<Daily> list = session.selectList("dailyboardMapper.selectMyDailyBoardList", user_id);
		return (ArrayList<Daily>)list;
	}
	public ArrayList<Diary> selectMyDiaryBoardList(String user_id) {
		List<Diary> list = session.selectList("diaryboardMapper.selectMyDiaryBoardList", user_id);
		return (ArrayList<Diary>)list;
	}

	public ArrayList<CareBoard> selectMyCareBoardList(String user_id){
		List<CareBoard> list = session.selectList("careboardMapper.selectMyCareBoardList", user_id);
		return (ArrayList<CareBoard>)list;
	}
	public ArrayList<PlaceBoard> selectMyPlaceBoardList(String user_id){
		List<PlaceBoard> list = session.selectList("placeboardMapper.selectMyPlaceBoardList", user_id);
		return (ArrayList<PlaceBoard>)list;
	}
	public ArrayList<Question> selectMyQuestionBoardList(String user_id){
		List<Question> list = session.selectList("questionboardMapper.selectMyQuestionBoardList", user_id);
		return (ArrayList<Question>)list;
	}

	public int updatepw(Member member) {
		return session.update("memberMapper.updatepw", member);
	}

	public int selectListCount() {
		return session.selectOne("memberMapper.selectListCount");
	}

	public int selectListCountSearch(Map<String, Object> params) {
		List<Member> list = session.selectList("memberMapper.selectListCountSearch", params);
		return list.size();
	}

	public ArrayList<Member> selectSearch(Map<String, Object> params) {
		List<Member> list = session.selectList("memberMapper.selectSearch", params);
		return (ArrayList<Member>)list;
	}
}
