package com.example.swagger292.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.swagger292.vo.Userinfo;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "Hello World! test";
    }

    @PostMapping("/signuptest")
    public ModelAndView signuptest(@RequestBody Userinfo vo){
        System.out.println("authoController: "+vo); //받아왔는지 확인
        ModelAndView mav = new ModelAndView("signuptest");
        mav.addObject("vo", vo);
        return mav;
    }
    
}
