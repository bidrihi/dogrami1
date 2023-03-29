package com.cono.dogrami.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cono.dogrami.member.model.dao.MemberDao;
import com.cono.dogrami.member.model.vo.Member;

@Service("MemberService")
public class MemberServiceImpl implements MemberService{
	//DAO 와 연결 처리
		@Autowired	//자동 DI 처리됨 : 자동 객체 생성됨
		MemberDao memberDao;
		
		@Override
		public Member selectLogin(Member member) {
			return memberDao.selectLogin(member);
		}

		@Override
		public int selectDupCheckId(String userid) {
			return memberDao.selectDupCheckId(userid);
		}

		@Override
		public Member selectMember(String userid) {
			return memberDao.selectMember(userid);
		}

		@Override
		public ArrayList<Member> selectList() {
			return memberDao.selectList();
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
		public int updateLoginok(Member member) {
			return memberDao.updateLoginok(member);
		}

		@Override
		public int deleteMember(String userid) {
			return memberDao.deleteMember(userid);
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
		public ArrayList<Member> selectSearchLoginOK(String keyword) {
			return memberDao.selectSearchLoginOK(keyword);
		}
}
