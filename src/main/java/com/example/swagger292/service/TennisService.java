package com.example.swagger292.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.swagger292.dao.TennisDao;
import com.example.swagger292.dto.TennisDTO;

@Service
public class TennisService {

    //생성자 주입
    private final TennisDao tennisDao;
    public TennisService(TennisDao tennisDao) {
        this.tennisDao = tennisDao;
    }

    //오픈 api 예약정보 insert
    public void saveTennis(TennisDTO dto){
        tennisDao.saveTennis(dto);
    }

    //예약정보 selectList
    public ArrayList<TennisDTO> selectList(){
        ArrayList<TennisDTO> list = tennisDao.selectList();
        return list;
    }

    //query search
    public ArrayList<TennisDTO> searchareanm(@RequestParam String query) {
        ArrayList<TennisDTO> dto = tennisDao.searchareanm(query);
        return dto;
    }

    
}
