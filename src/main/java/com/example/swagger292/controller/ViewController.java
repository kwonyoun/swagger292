package com.example.swagger292.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ViewController {

    @GetMapping("/")
    public ModelAndView main(){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @GetMapping("/signup")
    public ModelAndView signup(){
        ModelAndView mav = new ModelAndView("signup");
        return mav;
    }

    @GetMapping("/branch")
    public ModelAndView branch(){
        ModelAndView mav = new ModelAndView("branch");
        return mav;
    }

    @GetMapping("/photo")
    public ModelAndView photo(){
        ModelAndView mav = new ModelAndView("photo");
        return mav;
    }

    @GetMapping("/community")
    public ModelAndView community(){
        ModelAndView mav = new ModelAndView("community");
        return mav;
    }
    
}
