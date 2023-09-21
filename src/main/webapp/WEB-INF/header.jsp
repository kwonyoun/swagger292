<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
                    <a href="/map" class="">서울 테니스장</a>
                    <ul class="sub_menu">
                        <li><a href="../sub/sub01_01.html">포시즌 테니스</a></li>
                        <li><a href="../sub/sub01_02.html">오시는 길</a></li>
                    </ul>
                </li>
                <li>
                    <a href="https://innate-leopon-786.notion.site/9b15f97de73d4fc0995ecff349145675?pvs=4" class="">코치소개</a>
                </li>
                <li>
                    <a href="../sub/sub03_01.html" class="">레슨안내</a>
                    <ul class="sub_menu" style="display: none; height: 107.667px; padding-top: 0px; margin-top: 0px; padding-bottom: 0px; margin-bottom: 0px;">
                        <li><a href="../sub/sub03_01.html">레슨 프로그램</a></li>
                        <li><a href="../sub/sub07_02.html?ptype=view&amp;idx=5676&amp;page=1&amp;code=event">레슨비 안내</a></li>
                        <li><a href="../sub/sub03_02.html">중요공지</a></li>
                    </ul>
                </li>
                <li>
                    <a href="../sub/sub04_01.html" class="">스크린테니스</a>
                    <ul class="sub_menu" style="display: none; height: 107.667px; padding-top: 0px; margin-top: 0px; padding-bottom: 0px; margin-bottom: 0px;">
                        <li><a href="../sub/sub04_02.html">스크린테니스</a></li>
                        <li><a href="../sub/sub04_01.html">이용 안내</a></li>
                        <li><a href="https://4stas.com/sub/login.php" target="_blank">온라인 예약</a></li>
                    </ul>
                </li>
                <li>
                    <a href="../sub/sub06_01.html" class="">포토갤러리</a>
                </li>
                <li>
                    <a href="../sub/sub05_01.html" class="">시설안내</a>
                </li>
                <li>
                    <a href="../sub/sub07_01.html" class="">커뮤니티</a>
                    <ul class="sub_menu" style="display: none; height: 72.6667px; padding-top: 0px; margin-top: 0px; padding-bottom: 0px; margin-bottom: 0px;">
                        <li><a href="../sub/sub07_01.html">공지사항</a></li>
                        <li><a href="../sub/sub07_02.html">이벤트</a></li>
                    </ul>
                </li>
            </ul>
            <div class="top_member">
                <ul>
                    <li><a href="/login" class="login">로그인</a></li>
                    <li>|</li>
                    <li><a href="/signup" class="join">회원가입</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<!-- <header>
<div id="container" style="width: 1080px; margin: 0 auto; background-color: white;" >
<a href="/login">로그인</a>
<a href="/logout">logout</a>
<a href="/signup">회원가입</a>
<a href="/open-api/list">목록</a>
${pageContext.request.userPrincipal.name}
</div>
</header> -->
</html>