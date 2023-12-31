package com.example.swagger292.vo;

import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class Userinfo {
    private int userno;
    private String userid;
    private String userpw;
    private String username;

    private String branchid;
    private String branch;
    private String roles;

    private Userinfo(String userid, String userpw,String username, String roles,String branch) {
        // this.userno = userno;
        this.userid = userid;
        this.userpw = userpw;
        this.username=username;
        this.roles = roles;
        this.branch = branch;
    }

    protected Userinfo() {}

    public static Userinfo createUser(Userinfo vo, PasswordEncoder passwordEncoder) {
        System.out.println("hhh  "+vo);
        //여기서 비밀번호 암호화 처리함 .encode()
        return new Userinfo(vo.getUserid(), passwordEncoder.encode(vo.getUserpw()),vo.getUsername(),"USER",vo.getBranchid());
    }
    
}
