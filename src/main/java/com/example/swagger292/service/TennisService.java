package com.example.swagger292.service;

import org.springframework.stereotype.Service;

import com.example.swagger292.dao.TennisDao;
import com.example.swagger292.dto.TennisDTO;

@Service
public class TennisService {

    //생성자 주입
    private final TennisDao tennisDao;
    public TennisService(TennisDao tennisDao) {
        this.tennisDao = tennisDao;
    }

    public void saveTennis(TennisDTO dto){
        tennisDao.saveTennis(dto);
    }


    
}
