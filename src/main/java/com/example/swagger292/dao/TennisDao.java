package com.example.swagger292.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.swagger292.dto.TennisDTO;

@Mapper
public interface TennisDao {

    public void saveTennis(TennisDTO dto);
    
}
