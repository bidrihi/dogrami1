package com.cono.dogrami.hairshop.model.service;

import java.util.ArrayList;
import java.util.Map;
import com.cono.dogrami.common.Paging;
import com.cono.dogrami.hairshop.model.vo.Hairshop;

public interface HairshopService {

	// 전체리스트
	ArrayList<Hairshop> selectList(Paging page);

	// 전체 갯수
	int selectListCount();

	// 검색장소 리스트
	ArrayList<Hairshop> selectSearchList(Map<String, Object> params);

	// 검색장소 갯수
	int selectListCountSearch(Map<String, Object> params);

}
