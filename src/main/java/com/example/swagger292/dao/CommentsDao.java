package com.example.swagger292.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.swagger292.dto.CommentsDTO;

@Mapper
public interface CommentsDao {
    public void commentsInsert(CommentsDTO params);
    
}
