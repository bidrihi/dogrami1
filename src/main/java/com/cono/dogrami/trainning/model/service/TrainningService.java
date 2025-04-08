package com.cono.dogrami.trainning.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.trainning.model.vo.Trainning;

public interface TrainningService {

	// 전체리스트
	ArrayList<Trainning> selectList(Paging page);

	// 전체 갯수
	int selectListCount();

	// 검색장소 리스트
	ArrayList<Trainning> selectSearchList(Map<String, Object> params);

	// 검색장소 갯수
	int selectListCountSearch(Map<String, Object> params);
}
