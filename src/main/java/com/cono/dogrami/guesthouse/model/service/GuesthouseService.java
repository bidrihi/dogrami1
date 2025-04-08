package com.cono.dogrami.guesthouse.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.guesthouse.model.vo.Guesthouse;


public interface GuesthouseService {
	
	//전체리스트
		ArrayList<Guesthouse> selectList(Paging page);
		//전체 갯수
		int selectListCount();
			
		//검색장소 리스트
		ArrayList<Guesthouse> selectSearchList(Map<String, Object> params);
		
		//검색장소 갯수
		int selectListCountSearch(Map<String,Object> params);
}
