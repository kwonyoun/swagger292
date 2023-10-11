package com.example.swagger292.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.swagger292.dao.AdminDao;
import com.example.swagger292.vo.Userinfo;

@Service
public class AdminService {

    private final AdminDao dao;
    public AdminService(AdminDao dao) {
        this.dao = dao;
    }

    public ArrayList<Userinfo> selectUserList(){
        ArrayList<Userinfo> list = dao.selectUserList();
        return list;
    }
    

}
