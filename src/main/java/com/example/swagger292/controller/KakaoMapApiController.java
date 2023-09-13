package com.example.swagger292.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class KakaoMapApiController {

    @GetMapping("/map")
    public ModelAndView map(){
        ModelAndView mav = new ModelAndView("map");
        return mav;
    }
    
}
