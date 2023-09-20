package com.example.swagger292.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.swagger292.dao.UserDao;
import com.example.swagger292.vo.Userinfo;

@Service
public class LoginIdPwValidator implements UserDetailsService {
    // @Bean
    // public PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }
    
    @Autowired
    private UserDao mapper;

    @Override
    public UserDetails loadUserByUsername(String insertedId) throws UsernameNotFoundException {
        Userinfo user = mapper.getUserById(insertedId);
        
        if (user == null) {
            return null;
        }
        
        String pw = user.getUserpw(); //"d404559f602eab6fd602ac7680dacbfaadd13630335e951f097af3900e9de176b6db28512f2e000b9d04fba5133e8b1c6e8df59db3a8ab9d60be4b97cc9e81db"
        String roles = user.getRoles(); //"USER"
        System.out.println(pw+roles);

        return User.builder()
                .username(insertedId)
                .password(pw)
                .roles(roles)
                .build();
    }
}
