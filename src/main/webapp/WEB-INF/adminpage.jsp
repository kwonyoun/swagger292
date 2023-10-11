<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>adminpage</title>
    <link rel="stylesheet" href="/css/community.css"></link>
</head>
<body>
    
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="AW_bbs_table">
        <thead>
        <tr>
           <td width="1%"></td>
           <th width="8%" height="38">아이디</th>
           <th>이름</th>
           <th width="12%">지점</th>
           <th width="12%">승인</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${list}">
                <tr style="">
                    <td align="center"></td>
                    <td align="center" height="38">${item.userid}</td>
                    <td align="center">${item.username}</td>
                    <td align="center">${item.branch}</td>
                    <td>
                        <button><a href="/adminpage/permit?userno=${item.userno}">허가</a> </button>
                        <button><a href="/adminpage/cancel?userno=${item.userno}">삭제</a> </button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


</body>
</html>