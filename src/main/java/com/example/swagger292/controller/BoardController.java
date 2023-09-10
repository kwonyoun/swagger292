package com.example.swagger292.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger292.service.BoardService;
import com.example.swagger292.vo.BoardVo;

@RestController
@RequestMapping("/board")
public class BoardController {

    // @Autowired
    // BoardService boardService;

    private final BoardService boardService;
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping("/list")
    public String list(Model model){
        ArrayList<BoardVo> vo = boardService.selectList();
        System.out.println(vo);
        model.addAttribute("vo", vo);
        return "boardlist";
    }
    
}
