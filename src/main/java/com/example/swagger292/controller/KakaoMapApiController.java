package com.example.swagger292.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.swagger292.dto.TennisDTO;
import com.example.swagger292.service.TennisService;

@Controller
public class KakaoMapApiController {

    //생성자 주입
    private final TennisService tennisvc;
    public KakaoMapApiController(TennisService tennisvc) {
        this.tennisvc = tennisvc;
    }

    @GetMapping("/map")
    public String map() {
        return "map";
    }

    @GetMapping("/map/data")
    @ResponseBody // JSON 응답을 생성하도록 설정
    public ArrayList<TennisDTO> mapData() {
        ArrayList<TennisDTO> vo = tennisvc.selectList();
        return vo;
    }

    @GetMapping("/reservation")
    @ResponseBody
    public ArrayList<TennisDTO> reservation() {
        ArrayList<TennisDTO> vo = tennisvc.selectList();
        return vo;
    }
    
}
