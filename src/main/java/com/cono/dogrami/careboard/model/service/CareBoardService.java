package com.cono.dogrami.careboard.model.service;

import java.util.ArrayList;

import com.cono.dogrami.careboard.model.vo.CareBoard;


public interface CareBoardService {
	
	int selectListCount();   //총 게시글 갯수 조회용 (페이지 수 계산용)
	ArrayList<CareBoard> SelectList();
	ArrayList<CareBoard> SelectNick(String keyword);
	ArrayList<CareBoard> SelectTtile(String keyword);
	ArrayList<CareBoard> SelectLocation(String keyword);
	int insertBoard(CareBoard board);
	int updateBoard(CareBoard board);
	int deleteBoard(int careNo);
	CareBoard SelectOne(int careNo);
}
