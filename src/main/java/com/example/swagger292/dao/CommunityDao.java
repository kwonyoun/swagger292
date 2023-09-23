package com.example.swagger292.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.swagger292.vo.CommunityVo;
import com.example.swagger292.vo.PageVO;

@Mapper
public interface CommunityDao {

    public ArrayList<CommunityVo> selectQna();
    public List<CommunityVo>getList(PageVO pageVO);
    public int getListCnt(PageVO pageVO);
    
}
