package com.cono.dogrami.shop.model.dao;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.shop.model.vo.Shop;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("shopDao")
public class ShopDao {

    @Autowired
    private SqlSessionTemplate session;

    public ArrayList<Shop> selectList(Paging page) {
        List<Shop> list = session.selectList("shopMapper.selectList", page);
        return (ArrayList<Shop>) list;
    }

    public ArrayList<Shop> selectSearch(Map<String, Object> params) {
        List<Shop> list = session.selectList("shopMapper.selectSearch", params);
        return (ArrayList<Shop>) list;
    }

    public int selectListCount() {
        return session.selectOne("shopMapper.selectListCount");
    }

    public int selectListCountSearch(Map<String, Object> params) {
        List<Shop> list = session.selectList("shopMapper.selectListCountSearch", params);
        return list.size();
    }

    public int insertShop(Shop shop) {
        return session.insert("shopMapper.insertShop", shop);
    }

    public int updateShop(Shop shop) {
        return session.update("shopMapper.updateShop", shop);
    }

    public int deleteShop(int shop_no) {
        return session.delete("shopMapper.deleteShop", shop_no);
    }

    public Shop selectShop(int shop_no) {
        return session.selectOne("shopMapper.selectShop", shop_no);
    }
}
