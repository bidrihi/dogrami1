package com.cono.dogrami.shop.model.service;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.shop.model.vo.Shop;

import java.util.ArrayList;
import java.util.Map;

public interface ShopService {

    //샵 리스트
    ArrayList<Shop> selectList(Paging page);

    //샵 검색
    ArrayList<Shop> selectSearch(Map<String, Object> params);

    //총 샵 갯수 조회용 (페이징 처리용)
    int selectListCount();

    //샵 검색시 목록 갯수 처리용
    int selectListCountSearch(Map<String, Object> params);

    //샵 추가
    int insertShop(Shop shop);

    //샵 수정
    int updateShop(Shop shop);

    //샵 삭제
    int deleteShop(int shop_no);

    Shop selectShop(int shop_no);
}
