package com.cono.dogrami.placeboard.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.cono.dogrami.placeboard.model.vo.PlaceBoard;

public interface PlaceBoardService {

	int selectListCount();	//조회수
	ArrayList<PlaceBoard> SelectList();
	ArrayList<PlaceBoard> SelectNick(String keyword);
	ArrayList<PlaceBoard> SelectTtile(String keyword);
	ArrayList<PlaceBoard> SelectLocation(String keyword);
	int insertBoard(PlaceBoard board);
	int updateBoard(PlaceBoard board);
	int deleteBoard(int boardNo);
	PlaceBoard SelectOne(int boardNo);
}
