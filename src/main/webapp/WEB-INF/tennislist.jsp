<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Board</title>
    <link rel="stylesheet" href="/css/board.css">
</head>
<body>

    <div class="container">
        <h1>Board Table</h1>
    </div>

    <c:forEach var="item" items="${vo}">
                     <div class="num">${item.svcstatnm} </div>
                     <div class="title">
                     
                     <a href="/open-api/search?query=접수중">검색</a>

                     </div>
                     <div class="writer">${item.minclassnm}</div>
                     <div class="writer">${item.svcurl}</div>
                     <div class="date">${item.svcnm}</div>
    </c:forEach>

</body>
</html>