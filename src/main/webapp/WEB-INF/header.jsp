<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>header</title>
</head>
<header>
<div id="container" style="width: 1080px; margin: 0 auto; background-color: white;" >
<a href="/login">로그인</a>
<a href="/logout">logout</a>
<a href="/signup">회원가입</a>
<a href="/open-api/list">목록</a>
${pageContext.request.userPrincipal.name}
</div>
    
</header>
</html>