package com.cono.dogrami.hotel.model.service;

import com.cono.dogrami.hotel.model.dao.HotelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hotelService")
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDao hotelDao;
}
