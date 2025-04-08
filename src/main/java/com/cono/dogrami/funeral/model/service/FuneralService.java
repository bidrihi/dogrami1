package com.cono.dogrami.funeral.model.service;

import java.util.ArrayList;
import java.util.Map;


import com.cono.dogrami.common.Paging;
import com.cono.dogrami.funeral.model.vo.Funeral;

public interface FuneralService {
	
	//전체리스트
	ArrayList<Funeral> selectList(Paging page);
	//전체 갯수
	int selectListCount();
		
	//검색장소 리스트
	ArrayList<Funeral> selectSearchList(Map<String, Object> params);
	
	//검색장소 갯수
	int selectListCountSearch(Map<String,Object> params);

}
