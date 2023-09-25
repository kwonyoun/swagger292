<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>포토갤러리</title>
    <link rel="stylesheet" href="/css/photo.css"></link>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div style="margin-top: 100px;" >
        <!-- <img src="/imgs/lock.png"> -->
        <div id="wrap"  >
            <div id="content" >
                
                <div id="prod-wrap" >
                    
                    <ul class="prod">
                        <!-- <c:forEach var="vo" items="${vo}"> -->
                            <li>
                                <!-- <a href="/prod?prodNum=${vo.prodNum}"> -->
                                    <img style="width: 240px; height: 240px;" src="/imgs/lock.png">
                                <!-- </a>
                                <div style="width: 240px;" >${vo.prodName}</div> -->
                            </li>
                        <!-- </c:forEach> -->
                        <li>
                                <img style="width: 240px; height: 240px;" src="/imgs/tennis-logo.png">
                        </li>
                        <li>
                                <img style="width: 240px; height: 240px;" src="/imgs/index-bn.png">
                        </li>
                    </ul>
                    
                        
                </div>
                
            </div>
        </div>
    </div>
</body>
</html>