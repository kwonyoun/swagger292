package com.example.swagger292.service;

import org.springframework.stereotype.Service;

import com.example.swagger292.dao.CommentsDao;
import com.example.swagger292.dto.CommentsDTO;
import com.example.swagger292.vo.CommunityVo;

@Service
public class CommentsService {

    private final CommentsDao dao;
    public CommentsService(CommentsDao dao) {
        this.dao = dao;
    }
    
    //댓글 insert
    public void commentsInsert(CommentsDTO params){
        dao.commentsInsert(params);
    }
}
