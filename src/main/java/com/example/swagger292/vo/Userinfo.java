package com.example.swagger292.vo;

import javax.validation.constraints.NotBlank;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class Userinfo {
    // private int userno;
    @NotBlank(message = "아이디는 필수 입력사항 입니다.")
    private String userid;

    @NotBlank(message = "비밀번호는 필수 입력사항 입니다.")
    private String userpw;

    @NotBlank(message = "이름은 필수 입력사항 입니다.")
    private String username;

    private String branchid;
    private String roles;

    // private Userinfo(String id, String pw,String name, String roleUser,String branch) {
    //     // this.userno = userno;
    //     this.userid = id;
    //     this.userpw = pw;
    //     this.username=name;
    //     this.roles = roleUser;
    //     this.branch = branch;
    // }

    // protected Userinfo() {}

    // public static Userinfo createUser(Userinfo vo, PasswordEncoder passwordEncoder) {
    //     //여기서 비밀번호 암호화 처리함 .encode()
    //     return new Userinfo(vo.getUserid(), passwordEncoder.encode(vo.getUserpw()),vo.getUsername(),"USER",vo.getBranch());
    // }
    
}
