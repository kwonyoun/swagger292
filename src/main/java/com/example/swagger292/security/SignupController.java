package com.example.swagger292.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger292.service.UserService;
import com.example.swagger292.vo.Userinfo;

@RestController
@RequestMapping( value = "/signup")
public class SignupController {

    //생성자 주입
    private final UserService usersvc;
    public SignupController(UserService usersvc) {
        this.usersvc = usersvc;
    }    

    @PostMapping( value = "/process")
    public ResponseEntity<String> join(@RequestBody Userinfo vo) {
        try {
            System.out.println("SignupController: "+vo); //받아왔는지 확인
            //가입 insert
            usersvc.signup(vo); 

            return ResponseEntity.ok("join success"); //스웨거에서 확인 시 이 문구가 나온다. 
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
