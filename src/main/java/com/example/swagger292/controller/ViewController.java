package com.example.swagger292.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.swagger292.dto.TopBranchDTO;
import com.example.swagger292.service.CommunityService;
import com.example.swagger292.service.TennisService;
import com.example.swagger292.vo.CommunityVo;
import com.example.swagger292.vo.PageVO;
import com.example.swagger292.vo.Pagination;

@RestController
public class ViewController {

    //생성자 주입
    private final TennisService tennisvc;
    private final CommunityService commsvc;
    public ViewController(TennisService tennisvc, CommunityService commsvc) {
        this.tennisvc = tennisvc;
        this.commsvc = commsvc;
    }

    @GetMapping("/")
    public ModelAndView main(){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @GetMapping("/signup")
    public ModelAndView signup(){
        ModelAndView mav = new ModelAndView("signup");
        return mav;
    }

    @GetMapping("/branch")
    public ModelAndView branch(){
        ModelAndView mav = new ModelAndView("branch");
        ArrayList<TopBranchDTO> vo = tennisvc.selectBranchList();
        mav.addObject("vo", vo);
        return mav;
    }

    @GetMapping("/photo")
    public ModelAndView photo(){
        ModelAndView mav = new ModelAndView("photo");
        return mav;
    }

    @GetMapping("/community")
    public ModelAndView community(){
        ModelAndView mav = new ModelAndView("community");

        PageVO pageVO = new PageVO(); //PageVO객체 생성

        Pagination pagination = new Pagination();//화면에서 보여질 페이지 클래스
        pagination.setCurrentPageNo(pageVO.getPageIndex()); //현재 페이지 번호를 설정
        pagination.setRecordCountPerPage(pageVO.getPageUnit()); //한 페이지 당 게시되는 게시물 수
        pagination.setPageSize(pageVO.getPageSize()); //페이지 리스트에 게시되는 페이지 수

        pageVO.setFirstIndex(pagination.getFirstRecordIndex()); //
        pageVO.setRecordCountPerPage(pagination.getRecordCountPerPage());

        List<CommunityVo> boardList = commsvc.getList(pageVO); //게시판을 데이터베이스에서 select하여 저장함.
        int totCnt = commsvc.getListCnt(pageVO); //페이징을 위해 게시글 수를 select하여 저장함.

        pagination.setTotalRecordCount(totCnt);
        
        pageVO.setEndDate(pagination.getLastPageNoOnPageList());
        pageVO.setStartDate(pagination.getFirstPageNoOnPageList());
        pageVO.setPrev(pagination.getXprev());
        pageVO.setNext(pagination.getXnext());

        // System.out.println(boardList);
        // System.out.println("totCnt"+totCnt);

        // model.addAttribute("qnalist", vo);
        mav.addObject("pageVO",pageVO);
        mav.addObject("boardList",boardList);
        mav.addObject("totCnt",totCnt);
        mav.addObject("totalPageCnt",(int)Math.ceil(totCnt / (double)pageVO.getPageUnit()));
        mav.addObject("pagination",pagination);

        return mav;
    }
    
}
