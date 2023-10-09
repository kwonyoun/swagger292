package com.example.swagger292.security;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
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
    public ResponseEntity<String> join(@Valid Userinfo vo, Errors errors) {
        try {
             /* post요청시 넘어온 user 입력값에서 Validation에 걸리는 경우 */
            if (errors.hasErrors()) {
                /* 회원가입 실패시 입력 데이터 유지 */
                // model.addAttribute("userDTO", userDTO);
                /* 회원가입 실패시 message 값들을 모델에 매핑해서 View로 전달 */
                Map<String, String> validateMap = new HashMap<>();

                for (FieldError error : errors.getFieldErrors()) {
                    String validKeyName = "valid_" + error.getField();
                    validateMap.put(validKeyName, error.getDefaultMessage());
                }

                // map.keySet() -> 모든 key값을 갖고온다.
                // 그 갖고온 키로 반복문을 통해 키와 에러 메세지로 매핑
                // for (String key : validateMap.keySet()) {
                        // model.addAttribute(key, validateMap.get(key1));
                // }
                return ResponseEntity.ok("join fail");
            }
            System.out.println("SignupController: "+vo); //받아왔는지 확인
            //가입 insert
            usersvc.signup(vo); 
            return ResponseEntity.ok("join success"); //스웨거에서 확인 시 이 문구가 나온다. 

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
