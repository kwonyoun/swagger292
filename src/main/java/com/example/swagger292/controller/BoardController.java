package com.example.swagger292.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/list/test")
    public String listtest(Model model){
        ArrayList<BoardVo> vo = boardService.selectList();
        //객체 vo에서 override는 toString은 값을 가져왔는지 테스트하기 위해 만듬.
        // model.addAttribute("list", vo);
        return vo.toString();
    }

    @GetMapping("/list")
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
