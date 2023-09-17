package com.example.swagger292.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.example.swagger292.dto.TennisDTO;

@Mapper
public interface TennisDao {

    public void saveTennis(TennisDTO dto);
    public ArrayList<TennisDTO> searchareanm(String query);
    public ArrayList<TennisDTO> selectList();
    public ArrayList<TennisDTO> mapMarkerList(HashMap map);
    public TennisDTO selectTennisView(String svcid);
    
}
