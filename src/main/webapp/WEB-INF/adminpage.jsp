<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>adminpage</title>
</head>
<body>
    

    <c:forEach var="item" items="${list}">
        <tr style="">
            <td align="center"></td>
            <td align="center" height="38">${item.userid}</td>
            <td align="center">${item.username}</td>
            <td align="center">${item.branch}</td>
        </tr>
    </c:forEach>


</body>
</html>