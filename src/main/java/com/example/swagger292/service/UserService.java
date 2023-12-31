package com.example.swagger292.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.swagger292.dao.UserDao;
import com.example.swagger292.vo.Userinfo;

@Service
@Validated
public class UserService {

    private final UserDao dao;
    private final PasswordEncoder passwordEncoder;
    public UserService(PasswordEncoder passwordEncoder, UserDao dao) {
        this.passwordEncoder = passwordEncoder;
        this.dao = dao;
    }

    //회원가입
    public void signup(@Valid Userinfo userVo) { // 회원 가입
        String branch = userVo.getBranchid();
        String branchCode;
System.out.println("svc");
        if (branch.equals("노원점")) {
            branchCode = "1";
        } else if (branch.equals("옥수점")) {
            branchCode = "2";
        } else if (branch.equals("마포점")) {
            branchCode = "3";
        } else if (branch.equals("서강점")) {
            branchCode = "4";
        } else if (branch.equals("이대점")) {
            branchCode = "5";
        } else if (branch.equals("목동점")) {
            branchCode = "6";
        } else if (branch.equals("신도림점")) {
            branchCode = "7";
        } else { 
            branchCode = "8" ; 
        }
        userVo.setBranchid(branchCode);

        // password는 암호화해서 DB에 저장           
        Userinfo.createUser(userVo, passwordEncoder); //Userinfo의 메서드 creatUser가 static이기 때문에 클래스의 인스턴스를 호출하고 않고, 직접 호출할 수 있다!
        // userVo.setUserpw(passwordEncoder.encode(userVo.getUserpw()));
        // userVo.setRoles("USER");
        
        // System.out.println("svc: "+userVo);
        dao.insertUser(userVo);
    }

    //로그인 
    public Userinfo getUserById(String id) {
        return dao.getUserById(id);
    }

    // public List<Userinfo> getUserList() {
    //     return userMapper.getUserList();
    // }

    

    // public Userinfo getUserByEmail(String email) {
    //     return userMapper.getUserByEmail(email);
    // }

    

    // public void edit(Userinfo userVo) { // 회원 정보 수정
 	// 	// password는 암호화해서 DB에 저장      
    //     userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
    //     userMapper.updateUser(userVo);
    // }

    // public void withdraw(Long id) { // 회원 탈퇴
    //     userMapper.deleteUser(id);
    // }

    
}