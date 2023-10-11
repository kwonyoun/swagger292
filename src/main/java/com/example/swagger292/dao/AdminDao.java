package com.example.swagger292.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.swagger292.vo.Userinfo;

@Mapper
public interface AdminDao {

    public ArrayList<Userinfo> selectUserList();
    public void updatePermit(int userno);
    public void cancelMethod(int userno);
    
}
