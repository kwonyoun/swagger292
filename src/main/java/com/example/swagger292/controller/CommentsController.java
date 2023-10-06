package com.example.swagger292.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
        public String comments(@RequestBody final CommentsDTO params) {
            try {
                svc.commentsInsert(params);
                return "success";
            } catch (Exception e) {
                System.out.println(e.getStackTrace());
                return "fail";
            }
        }
        @GetMapping
        public ModelAndView viewComments(){  
            ModelAndView mav = new ModelAndView("redirect:/community/view?idno");
            return mav;
        }
    
}
