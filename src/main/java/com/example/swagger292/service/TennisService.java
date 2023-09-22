package com.example.swagger292.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.swagger292.dao.TennisDao;
import com.example.swagger292.dto.TennisDTO;
import com.example.swagger292.dto.TopBranchDTO;

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

    //지도에서 마커클릭 후 예약정보확인 selectList
    public ArrayList<TennisDTO> mapMarkerList(HashMap map){
        ArrayList<TennisDTO> list = tennisDao.mapMarkerList(map);
        return list;
    }

    //query search
    public ArrayList<TennisDTO> searchareanm(@RequestParam String query) {
        ArrayList<TennisDTO> dto = tennisDao.searchareanm(query);
        return dto;
    }

    //예약정보 selectList
    public TennisDTO selectTennisView(String svcid){
        TennisDTO list = tennisDao.selectTennisView(svcid);
        return list;
    }

    //예약정보 selectList
    public ArrayList<TopBranchDTO> selectBranchList(){
        ArrayList<TopBranchDTO> list = tennisDao.selectBranchList();
        return list;
    }

    
}
