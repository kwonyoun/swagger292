package com.example.swagger292.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.swagger292.service.AdminService;
import com.example.swagger292.vo.Userinfo;

@RestController
@RequestMapping(value = "/adminpage", method = RequestMethod.GET)
public class AdminController {

    private final AdminService svc;
    public AdminController(AdminService svc) {
        this.svc = svc;
    }

    //신규회원 허가를 위한 메소드
    @GetMapping
    public ModelAndView permit(){
        ModelAndView mav = new ModelAndView("adminpage");
        ArrayList<Userinfo> list = svc.selectUserList();
        mav.addObject("list", list);
        return mav;
    }
    
}
