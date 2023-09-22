package com.example.swagger292.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.swagger292.dto.TennisDTO;
import com.example.swagger292.dto.TopBranchDTO;
import com.example.swagger292.service.TennisService;

import lombok.experimental.var;

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

    @GetMapping("/detailView")
    @ResponseBody
    public ModelAndView detailView(@RequestParam("svcid") String svcid) {
        ModelAndView mav = new ModelAndView("detailView");
        TennisDTO vo = tennisvc.selectTennisView(svcid);
        mav.addObject("vo", vo);
        return mav;
    }

    @GetMapping("/reservation")
    @ResponseBody
    public ModelAndView reservation(@RequestParam("svcid") String svcid) {
        ModelAndView mav = new ModelAndView("reservationView");
        TennisDTO vo = tennisvc.selectTennisView(svcid);
        mav.addObject("vo", vo);
        return mav;
    }

    @GetMapping("/map/branch")
    @ResponseBody // JSON 응답을 생성하도록 설정
    public ArrayList<TopBranchDTO> mapBranch() {
        ArrayList<TopBranchDTO> vo = tennisvc.selectBranchList();
        return vo;
    }
    
}
