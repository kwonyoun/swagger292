package com.example.swagger292.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CommunityController {

    @GetMapping(value="path")
    public ModelAndView getMethodName(@RequestParam String param) {
        ModelAndView mav = new ModelAndView("community");
        
        return mav;
    }
    
    
}
