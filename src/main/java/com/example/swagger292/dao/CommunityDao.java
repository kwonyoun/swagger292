package com.example.swagger292.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.swagger292.vo.CommunityVo;
import com.example.swagger292.vo.PageVO;

@Mapper
public interface CommunityDao {

    public ArrayList<CommunityVo> selectCommunity();
    public List<CommunityVo>getList(PageVO pageVO);
    public int getListCnt(PageVO pageVO);
    public void commnunityWriteProcess(CommunityVo vo);
    public CommunityVo getCommunityView(int idno);
    
}
