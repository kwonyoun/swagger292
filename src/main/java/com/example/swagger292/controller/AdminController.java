package com.example.swagger292.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    //신규회원 허가 대기 리스트
    @GetMapping
    public ModelAndView permitUserlist(){
        ModelAndView mav = new ModelAndView("adminpage");
        ArrayList<Userinfo> list = svc.selectUserList();
        mav.addObject("list", list);
        return mav;
    }

    //신규회원 허가 버튼 메소드
    @GetMapping(value = "/permit")
    public ModelAndView permitMethod(@RequestParam("userno") int userno){
        ModelAndView mav = new ModelAndView("redirect:/adminpage");
        svc.updatePermit(userno);
        return mav;
    }

    //신규회원 취소 버튼 메소드
    @GetMapping(value = "/cancel")
    public ModelAndView cancelMethod(@RequestParam("userno") int userno){
        ModelAndView mav = new ModelAndView("redirect:/adminpage");
        svc.cancelMethod(userno);
        return mav;
    }
    
}
