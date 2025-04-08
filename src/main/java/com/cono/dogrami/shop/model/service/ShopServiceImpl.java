package com.cono.dogrami.shop.model.service;

import com.cono.dogrami.common.Paging;
import com.cono.dogrami.shop.model.dao.ShopDao;
import com.cono.dogrami.shop.model.vo.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    public ArrayList<Shop> selectList(Paging page) {
        return shopDao.selectList(page);
    }

    @Override
    public ArrayList<Shop> selectSearch(Map<String, Object> params) {
        return shopDao.selectSearch(params);
    }

    @Override
    public int selectListCount() {
        return shopDao.selectListCount();
    }

    @Override
    public int selectListCountSearch(Map<String, Object> params) {
        return shopDao.selectListCountSearch(params);
    }

    @Override
    public int insertShop(Shop shop) {
        return shopDao.insertShop(shop);
    }

    @Override
    public int updateShop(Shop shop) {
        return shopDao.updateShop(shop);
    }

    @Override
    public int deleteShop(int shop_no) {
        return shopDao.deleteShop(shop_no);
    }

    @Override
    public Shop selectShop(int shop_no) {
        return shopDao.selectShop(shop_no);
    }
}
