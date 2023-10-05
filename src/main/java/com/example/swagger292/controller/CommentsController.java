package com.example.swagger292.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger292.dto.CommentsDTO;
import com.example.swagger292.service.CommentsService;

@RestController
@RequestMapping(value = "/comments")
public class CommentsController {

        private final CommentsService svc;
        public CommentsController(CommentsService svc) {
            this.svc = svc;
        }

    @PostMapping
    public String comments(@RequestBody final CommentsDTO params){
        System.out.println("welcome");
        System.out.println(params.toString());
        svc.commentsInsert(params);
        return "aa";
    }
    
}
