package com.example.swagger292.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.swagger292.dao.CommunityDao;
import com.example.swagger292.service.CommunityService;
import com.example.swagger292.vo.CommunityVo;
import com.example.swagger292.vo.PageVO;
import com.example.swagger292.vo.Pagination;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CommunityController {

    private final CommunityService svc;
    public CommunityController(CommunityService svc) {
        this.svc = svc;
    }

    @GetMapping(value="path")
    public ModelAndView getMethodName(@RequestParam String param) {
        ModelAndView mav = new ModelAndView("community");
        return mav;
    }

    @GetMapping("/community/page")
    public ModelAndView community(@RequestParam("pageIndex") int page){
        ModelAndView mav = new ModelAndView("community");
        PageVO pageVO = new PageVO(); //PageVO객체 생성

        Pagination pagination = new Pagination();//화면에서 보여질 페이지 클래스
        pagination.setCurrentPageNo(page); //현재 페이지 번호를 설정
        pagination.setRecordCountPerPage(pageVO.getPageUnit()); //한 페이지 당 게시되는 게시물 수
        pagination.setPageSize(pageVO.getPageSize()); //페이지 리스트에 게시되는 페이지 수

        pageVO.setFirstIndex(pagination.getFirstRecordIndex()); //
        pageVO.setRecordCountPerPage(pagination.getRecordCountPerPage());

        List<CommunityVo> boardList = svc.getList(pageVO); //게시판을 데이터베이스에서 select하여 저장함.
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        //datetime을 date로 보기
        for (CommunityVo community : boardList) {
            String datetimeString = community.getDate(); // 게시물의 datetime 값을 가져옴
            try {
                Date datetime = inputDateFormat.parse(datetimeString); // datetime 값을 Date 형식으로 파싱
                String dateOnly = outputDateFormat.format(datetime); // Date 값을 yyyy-MM-dd 형식의 문자열로 변환
                community.setDate(dateOnly); // 게시물의 datetime 값을 날짜 부분만으로 업데이트
            } catch (Exception e) {
                e.printStackTrace(); // 파싱 실패 시 예외 처리
            }
        }

        int totCnt = svc.getListCnt(pageVO); //페이징을 위해 게시글 수를 select하여 저장함.

        pagination.setTotalRecordCount(totCnt);
        
        pageVO.setEndDate(pagination.getLastPageNoOnPageList());
        pageVO.setStartDate(pagination.getFirstPageNoOnPageList());
        pageVO.setPrev(pagination.getXprev());
        pageVO.setNext(pagination.getXnext());

        mav.addObject("pageVO",pageVO);
        mav.addObject("boardList",boardList);
        mav.addObject("totCnt",totCnt);
        mav.addObject("totalPageCnt",(int)Math.ceil(totCnt / (double)pageVO.getPageUnit()));
        mav.addObject("pagination",pagination);

        return mav;
    }

    @PostMapping(value = "/community/write/process")
    public ModelAndView commnunityWriteProcess(@RequestParam("title") String title, @RequestParam("content") String content, @AuthenticationPrincipal UserDetails user){
        ModelAndView mav = new ModelAndView("redirect:/community");
        CommunityVo vo = new CommunityVo();
        vo.setTitle(title);
        vo.setContent(content);
        vo.setUserno(user.getUsername());
        svc.commnunityWriteProcess(vo);
        return mav;
    }

    //커뮤니티 view
    @GetMapping(value = "/community/view")
    public ModelAndView communityView(@RequestParam("commid") int commid, HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav = new ModelAndView("communityView");
        CommunityVo vo = svc.getCommunityView(commid);
        // System.out.println(vo);
        mav.addObject("vo", vo);
        viewCountUp(commid, request, response);

        return mav;
    } 

    private void viewCountUp(int commid, HttpServletRequest request, HttpServletResponse response) {

        /* 조회수 로직 */
		Cookie oldCookie = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("visit_cookie")) {
					oldCookie = cookie;
				}
			}
		}

        if (oldCookie != null) {
            if (!oldCookie.getValue().contains("[" + commid + "]")) {
                oldCookie.setValue(oldCookie.getValue() + "_[" + commid + "]");
                oldCookie.setPath("/");
                oldCookie.setMaxAge(60 * 60 * 2);  // 쿠키 시간
                response.addCookie(oldCookie);
                svc.viewCountUp(commid);
            }
        } else {
            Cookie newCookie = new Cookie("visit_cookie","[" + commid + "]");
            newCookie.setPath("/");
            newCookie.setMaxAge(60 * 60 * 2);  // 쿠키 시간
            response.addCookie(newCookie);
            svc.viewCountUp(commid);
        }

        
    }

    //커뮤니티 수정페이지
    @GetMapping(value = "/community/edit/{commid}")
    public ModelAndView communityEditPage(@PathVariable("commid") int commid){
        ModelAndView mav = new ModelAndView("communityEdit");
        CommunityVo vo = svc.getCommunityView(commid);
        // System.out.println(vo);
        mav.addObject("vo", vo);
        return mav;
    }

    //커뮤니티 수정메소드
    @PostMapping(value = "/community/edit/{commid}")
    public ModelAndView communityEdit(CommunityVo vo){
        int commid = vo.getCommid();
        svc.editCommunity(vo);
        ModelAndView mav = new ModelAndView("redirect:/community/view?commid="+commid);
        return mav;
    }

    //커뮤니티 글 삭제
    @GetMapping(value = "/community/delete/{commid}")
    public ModelAndView communityDelte(@PathVariable("commid") int commid){
        ModelAndView mav = new ModelAndView("redirect:/community");
        svc.deletePost(commid);
        return mav;
    }

   

    // @RequestMapping("/detail/{cate}/{id}")
	// public String detail(Model model, 
	// 		@PathVariable("id") Integer id, 
	// 		@PathVariable("cate") String cate,
	// 		AnswerForm answerForm, CommentForm commentForm, 
	// 		@RequestParam(value="page", defaultValue="0") int page,
	// 		HttpServletRequest request,
    //         HttpServletResponse response) {
	// 	Question question = this.questionService.getQuestion(id);
		
	// 	/* 조회수 로직 */
	// 	Cookie oldCookie = null;
	// 	Cookie[] cookies = request.getCookies();
	// 	if (cookies != null) {
	// 		for (Cookie cookie : cookies) {
	// 			if (cookie.getName().equals("postView")) {
	// 				oldCookie = cookie;
	// 			}
	// 		}
	// 	}
		
	// 	if (oldCookie != null) {
	// 		if (!oldCookie.getValue().contains("["+ id.toString() +"]")) {
	// 			this.questionService.updateView(id);
	// 			oldCookie.setValue(oldCookie.getValue() + "_[" + id + "]");
	// 			oldCookie.setPath("/");
	// 			oldCookie.setMaxAge(60 * 60 * 24); 							// 쿠키 시간
	// 			response.addCookie(oldCookie);
	// 		}
	// 	} else {
	// 		this.questionService.updateView(id);
	// 		Cookie newCookie = new Cookie("postView", "[" + id + "]");
	// 		newCookie.setPath("/");
	// 		newCookie.setMaxAge(60 * 60 * 24); 								// 쿠키 시간
	// 		response.addCookie(newCookie);
	// 	}
        
	// 	Page<Answer> answerPaging = this.answerService.getAnswerList(id, page);				// answerList는 페이징처리하여 별도로 조회하기
	// 	model.addAttribute("question", question);
	// 	model.addAttribute("answerPaging", answerPaging);
	// 	return "/question/question_detail";
	// }
    
    
}
