package com.example.swagger292.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger292.service.UserService;
import com.example.swagger292.vo.Userinfo;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // @GetMapping("/signup")
    // public String signupPage() {  // 회원 가입 페이지
    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //     if (authentication instanceof AnonymousAuthenticationToken)
    //         return "signup";
    //     return "redirect:/";
    // }

    @PostMapping("/signup")
    public String signup(Userinfo userVo) { // 회원 가입
        try {
            userService.signup(userVo);
        } catch (DuplicateKeyException e) {
            return "redirect:/signup?error_code=-1";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/signup?error_code=-99";
        }
        return "redirect:/login";
    }
    
}
