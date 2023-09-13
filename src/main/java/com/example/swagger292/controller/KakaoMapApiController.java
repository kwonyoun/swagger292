package com.example.swagger292.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class KakaoMapApiController {

    @GetMapping("/map")
    public String map(){
        return "map";
    }
    
}
