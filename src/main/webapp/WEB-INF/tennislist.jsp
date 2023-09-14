<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Board</title>
    <link rel="stylesheet" href="/css/tennis.css">
    <style>
        .search {
        position: relative;
        width: 300px;
        margin: 0 auto;
        margin-bottom: 30px;
        }

        input[type="text"] {
        width: 100%;
        border: 1px solid #bbb;
        border-radius: 8px;
        padding: 10px 12px;
        font-size: 14px;
        }

        input[type="submit"]  {
        position : absolute;
        width: 50px;
        top: 10px;
        right: 0;
        margin: 0;
        }
    </style>
</head>
<body>

    <div class="container">
        <h1>서울특별시 체육시설 테니스장 예약정보</h1>
    </div>
    <!-- <a href="/open-api/search?query=접수중">검색</a> -->
    <form action="/open-api/search" method="post" >
        <div class="search">
            <input type="text" name="query" placeholder="검색어 입력" value="${query}" >
            <input type="submit" value="검색">
        </div>
    </form>
                    
    <table class="rwd-table">
        <tbody>
            <tr>
                <th>전화번호</th>
                <th>링크</th>
                <th>지역</th>
                <th>주소</th>
                <th>상황</th>
              </tr>
            <c:forEach var="item" items="${vo}">
                <tr>
                    <td data-th="Due Date">
                        ${item.telno}
                    </td>
                    <td data-th="Supplier Name">
                        <a href="${item.svcurl}">예약 바로가기</a>
                    </td>
                    <td data-th="Invoice Number">
                        <div class="writer">${item.areanm}</div>
                    </td>
                    <td data-th="Invoice Date">
                        ${item.svcnm}
                    </td>
                    <td data-th="Supplier Code">
                        ${item.svcstatnm}
                    </td>
                    
                        
                </tr>
                            <!-- <div class="num">${item.svcstatnm} </div>
                            <div class="title">
                                
                            
                            

                            </div>
                            <div class="writer">${item.minclassnm}</div>
                            <div class="writer">${item.svcurl}</div>
                            <div class="date">${item.svcnm}</div> -->
            </c:forEach>
        </tbody>
    </table>

</body>
</html>