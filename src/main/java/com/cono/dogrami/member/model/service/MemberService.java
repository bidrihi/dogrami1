package com.cono.dogrami.member.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.careboard.model.vo.CareBoard;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.daily.model.vo.Daily;
import com.cono.dogrami.diary.model.vo.Diary;
import com.cono.dogrami.member.model.vo.Member;
import com.cono.dogrami.placeboard.model.vo.PlaceBoard;
import com.cono.dogrami.question.model.vo.Question;


public interface MemberService {
	Member selectLogin(Member member);
	int selectDupCheckId(String user_id);
	Member selectMember(String user_id);
	ArrayList<Member> selectList(Paging page);
	int insertMember(Member member);
	int updateMember(Member member);
	int updateLoginLimit(Member member);
	int updateUserAdmin(Member member);
	int deleteMember(String user_id);
	//검색을 위한 메소드
	ArrayList<Member> selectSearchUserid(String keyword);
	ArrayList<Member> selectSearchUsernick(String keyword);
	ArrayList<Member> selectSearchUsername(String keyword);	
	ArrayList<Member> selectSearchLoginLimit(String keyword);
	ArrayList<Member> selectSearchUserAdmin(String keyword);
	
	// 내가 쓴글 목록 조회용
	ArrayList<Daily> selectMyDailyBoardList(String user_id); 
	ArrayList<Diary> selectMyDiaryBoardList(String user_id); 
	ArrayList<CareBoard> selectMyCareBoardList(String user_id); 
	ArrayList<PlaceBoard> selectMyPlaceBoardList(String user_id); 
	ArrayList<Question> selectMyQuestionBoardList(String user_id);

	//임시 비밀번호 변경
	int updatepw(Member member);
	int selectListCount();
	//검색을 위한 메소드
	ArrayList<Member> selectSearch(Map<String, Object> params);
	int selectListCountSearch(Map<String, Object> params);
}
