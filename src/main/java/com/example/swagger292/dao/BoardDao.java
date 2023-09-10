package com.example.swagger292.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.swagger292.vo.BoardVo;

@Mapper
public interface BoardDao {
    public ArrayList<BoardVo> selectList();
    
}
