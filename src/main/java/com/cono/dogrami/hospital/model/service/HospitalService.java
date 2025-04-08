package com.cono.dogrami.hospital.model.service;

import java.util.ArrayList;
import java.util.Map;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.hospital.model.vo.Hospital;

public interface HospitalService {

		//전체리스트
		ArrayList<Hospital> selectList(Paging page);
		//전체 갯수
		int selectListCount();
			
		//검색장소 리스트
		ArrayList<Hospital> selectSearchList(Map<String, Object> params);
		//검색장소 갯수
		int selectListCountSearch(Map<String,Object> params);
}
