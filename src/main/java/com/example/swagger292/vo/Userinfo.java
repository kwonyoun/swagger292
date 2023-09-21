package com.example.swagger292.vo;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class Userinfo {
    // private int userno;
    private String userid;
    private String userpw;
    private String username;
    private String roles;

    private Userinfo(String id, String pw,String name, String roleUser) {
        // this.userno = userno;
        this.userid = id;
        this.userpw = pw;
        this.username=name;
        this.roles = roleUser;
    }

    protected Userinfo() {}

    public static Userinfo createUser(Userinfo vo, PasswordEncoder passwordEncoder) {
        //여기서 비밀번호 암호화 처리함 .encode()
        return new Userinfo(vo.getUserid(), passwordEncoder.encode(vo.getUserpw()),vo.getUsername(),"USER");
    }
    
}