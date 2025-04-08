package com.cono.dogrami.cafe.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.cafe.model.vo.Cafe;
import com.cono.dogrami.common.Paging;

public interface CafeService {

	// 전체리스트
	ArrayList<Cafe> selectList(Paging page);

	// 전체 갯수
	int selectListCount();

	// 검색장소 리스트
	ArrayList<Cafe> selectSearchList(Map<String, Object> params);

	// 검색장소 갯수
	int selectListCountSearch(Map<String, Object> params);
}
