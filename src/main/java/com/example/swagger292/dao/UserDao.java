package com.example.swagger292.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.swagger292.vo.Userinfo;

@Mapper
public interface UserDao {
    // public Userinfo findByUserid(String userId);
    // public int insertJoin(Userinfo member);

    // List<Userinfo> getUserList(); // User 테이블 가져오기
    void insertUser(Userinfo userVo); // 회원 가입
    // Userinfo getUserByEmail(String email); // 회원 정보 가져오기
    Userinfo getUserById(String id);
    // void updateUser(Userinfo userVo); // 회원 정보 수정
    // void deleteUser(Long id); // 회원 탈퇴
}
