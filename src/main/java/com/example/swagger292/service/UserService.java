package com.example.swagger292.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.swagger292.dao.UserDao;
import com.example.swagger292.vo.Userinfo;

@Service
public class UserService {

    @Autowired
    private UserDao userMapper;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // public List<Userinfo> getUserList() {
    //     return userMapper.getUserList();
    // }

    public Userinfo getUserById(String id) {
        return userMapper.getUserById(id);
    }

    // public Userinfo getUserByEmail(String email) {
    //     return userMapper.getUserByEmail(email);
    // }

    public void signup(Userinfo userVo) { // 회원 가입
		    // password는 암호화해서 DB에 저장           
            userVo.setUserpw(passwordEncoder.encode(userVo.getUserpw()));
            userMapper.insertUser(userVo);
    }

    // public void edit(Userinfo userVo) { // 회원 정보 수정
 	// 	// password는 암호화해서 DB에 저장      
    //     userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
    //     userMapper.updateUser(userVo);
    // }

    // public void withdraw(Long id) { // 회원 탈퇴
    //     userMapper.deleteUser(id);
    // }

    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }
}