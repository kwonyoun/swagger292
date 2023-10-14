<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>header</title>
    <link rel="stylesheet" href="/css/header.css">
</head>
<header class="">
    <div class="bg"></div>
    <nav>
        <div class="inner">
            <div class="logo"  >
                <h1 class=""><a href="/"><span class="hidden"><img style="margin-left: 300px;" width="100px" height="70px" src="/imgs/tennis-logo.png"></span></a></h1>
            </div>
            <ul class="gnb">
                <li>
                    <a href="/map" class="">공공 테니스장</a>
                </li>
                <li>
                    <a href="https://innate-leopon-786.notion.site/9b15f97de73d4fc0995ecff349145675?pvs=4" class="">notion</a>
                </li>
                <li>
                    <a href="/branch" class="">각 지점 소개</a>
                </li>
                <li>
                    <a href="/photo" class="">포토갤러리</a>
                </li>
                <li>
                    <a href="/info" class="">시설안내</a>
                </li>
                <li>
                    <a href="/community" class="">커뮤니티</a>
                </li>
            </ul>
            <div class="top_member">
                <ul>
                    <c:if test="${pageContext.request.userPrincipal.name != null}" >
                        <sec:authorize access="hasRole('ADMIN')">
                            <li><a href="/adminpage">관리자페이지</a></li>
                            <li>${pageContext.request.userPrincipal.name}님</li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('USER')">
                            <li><a href="/mypage">마이페이지</a></li>
                            <li>${pageContext.request.userPrincipal.name}님</li>
                        </sec:authorize>
                        <li>|</li>
                        <li><a href="/logout" class="login">로그아웃</a></li>
                        
                    </c:if>
                    <a href="/signup" sec:authorize="isAnonymous()">회원가입</a>
                    <c:if test="${pageContext.request.userPrincipal.name == null}" >
                        <li>${pageContext.request.userPrincipal.name}<a href="/login" class="login">로그인</a></li>
                        <li>|</li>
                        <li><a href="/signup" class="join">회원가입</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</header>
</html>