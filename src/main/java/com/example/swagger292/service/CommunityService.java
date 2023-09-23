package com.example.swagger292.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swagger292.dao.CommunityDao;
import com.example.swagger292.vo.CommunityVo;
import com.example.swagger292.vo.PageVO;

@Service
public class CommunityService {

    @Autowired
    CommunityDao dao;

    //커뮤니티 목록
    public ArrayList<CommunityVo> selectQnaList() {
        ArrayList<CommunityVo> vo = dao.selectQna();
        return vo;

    }

    //페이징
    public List<CommunityVo> getList(PageVO pageVO) {
        return dao.getList(pageVO); 
    }

    public int getListCnt(PageVO pageVO) {
        return dao.getListCnt(pageVO);
    }
    
}
