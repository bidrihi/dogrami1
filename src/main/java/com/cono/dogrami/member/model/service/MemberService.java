package com.cono.dogrami.member.model.service;

import java.util.ArrayList;

import com.cono.dogrami.member.model.vo.Member;

public interface MemberService {
	Member selectLogin(Member member);
	int selectDupCheckId(String user_id);
	Member selectMember(String user_id);
	ArrayList<Member> selectList();
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
}
