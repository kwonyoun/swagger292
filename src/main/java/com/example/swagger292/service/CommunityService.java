package com.example.swagger292.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.swagger292.dao.CommunityDao;
import com.example.swagger292.dao.TennisDao;
import com.example.swagger292.vo.CommunityVo;
import com.example.swagger292.vo.PageVO;

@Service
public class CommunityService {

    private final CommunityDao dao;
    public CommunityService(CommunityDao dao) {
        this.dao = dao;
    }

    //커뮤니티 목록
    public ArrayList<CommunityVo> selectCommunity() {
        ArrayList<CommunityVo> vo = dao.selectCommunity();
        return vo;

    }

    //페이징
    public List<CommunityVo> getList(PageVO pageVO) {
        return dao.getList(pageVO); 
    }

    public int getListCnt(PageVO pageVO) {
        return dao.getListCnt(pageVO);
    }

    //커뮤니티 글쓰기 insert
    public void commnunityWriteProcess(CommunityVo vo){
        dao.commnunityWriteProcess(vo);
    }

    //커뮤니티 view
    public CommunityVo getCommunityView(int commid){
        CommunityVo vo  = dao.getCommunityView(commid);
        return vo;
    }

    //커뮤니티 edit
    public void editCommunity(CommunityVo vo){
        dao.editCommunity(vo);
    }

    //커뮤니티 게시글 delete
    public void deletePost(int commid){
        dao.deletePost(commid);
    }

   /* Views Counting */
	@Transactional
	public void viewCountUp(int commid) {
		this.dao.viewCountUp(commid);
	}
        
}
