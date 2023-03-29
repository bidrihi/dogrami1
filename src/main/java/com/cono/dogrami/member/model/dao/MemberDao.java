package com.cono.dogrami.member.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cono.dogrami.member.model.vo.Member;

@Repository("MemberDao")
public class MemberDao {
	@Autowired	//root-context.xml 에서 생성한 객체와 자동 연결
	private SqlSessionTemplate session;	//의존성 주입됨(DI)
	
	public Member selectLogin(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	public int selectDupCheckId(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Member selectMember(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Member> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateLoginok(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteMember(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Member> selectSearchUserid(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Member> selectSearchUsernick(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Member> selectSearchUsername(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Member> selectSearchLoginOK(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
}
