package com.cono.dogrami.member.model.service;

import java.util.ArrayList;

import com.cono.dogrami.member.model.vo.Member;

public interface MemberService {
	Member selectLogin(Member member);
	int selectDupCheckId(String userid);
	Member selectMember(String userid);
	ArrayList<Member> selectList();
	int insertMember(Member member);
	int updateMember(Member member);
	int updateLoginok(Member member);
	int deleteMember(String userid);
	//검색을 위한 메소드
	ArrayList<Member> selectSearchUserid(String keyword);
	ArrayList<Member> selectSearchUsernick(String keyword);
	ArrayList<Member> selectSearchUsername(String keyword);	
	ArrayList<Member> selectSearchLoginOK(String keyword);
}
