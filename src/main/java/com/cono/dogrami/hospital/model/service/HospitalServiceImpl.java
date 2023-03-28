package com.cono.dogrami.hospital.model.service;

import com.cono.dogrami.hospital.model.dao.HospitalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("hospitalService")
public class HospitalServiceImpl implements HospitalService {
    @Autowired
    private HospitalDao hospitalDao;
}
