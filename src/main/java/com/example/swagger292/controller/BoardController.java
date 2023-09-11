package com.example.swagger292.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.swagger292.service.BoardService;
import com.example.swagger292.vo.BoardVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/board")
@Slf4j
public class BoardController {

    // @Autowired
    // BoardService boardService;

    private final BoardService boardService;
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("/list/test")
    public String listtest(Model model){
        ArrayList<BoardVo> vo = boardService.selectList();
        // System.out.println(vo.toString());
        model.addAttribute("list", vo.toString());
        return vo.toString();
    }

    @RequestMapping("/list")
    public ModelAndView list(){

        ArrayList<BoardVo> vo = boardService.selectList();

        ModelAndView mav = new ModelAndView();
		
        mav.setViewName("boardlist");
        mav.addObject("vo", vo);
        mav.addObject("test", "test");
        log.debug("mav: "+mav.toString());
        // System.out.println(vo.toString());
        return mav;
    }
    
}
