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
    
}
