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

    //신규회원 허가 대기 리스트
    public ArrayList<Userinfo> selectUserList(){
        ArrayList<Userinfo> list = dao.selectUserList();
        return list;
    }
    
    //신규회원 허가 버튼 메소드
    public void updatePermit(int userno){
        dao.updatePermit(userno);
    }

    //신규회원 취소 버튼 메소드(그대로 유지)
    public void cancelMethod(int userno){
        dao.cancelMethod(userno);
    }

}
