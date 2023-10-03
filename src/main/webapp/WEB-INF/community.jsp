<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/community.css"></link>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
    <jsp:include page="header.jsp"/>
    <!-- community -->
    <div class="contents">
        <div class="contents_title">
            <h2 data-aos="slide-up" data-aos-duration="1000" class="aos-init aos-animate"><span>커뮤니티</span></h2>
        </div>

        <!-- admin에게만 보여지는 글쓰기 -->
        <c:if test="${pageContext.request.userPrincipal.name != null}" >
            <sec:authorize access="hasRole('ADMIN')">
                  <a href="/commnunity/write">글쓰기</a>
            </sec:authorize>
         </c:if>

        <!-- contents_detail start -->
        <div class="contents_detail">
            <div class="sub_notice">
                <div class="inner">
                    <div class="board">


            <!-- 게시물 시작 -->
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="AW_bbs_table">
               <thead>
               <tr>
                  <td width="1%"></td>
                  <th width="8%" height="38">번호</th>
                  <th>제목</th>
                  <th width="12%">작성자</th>
                  <th width="12%">작성일</th>
                  <th width="8%">조회</th>
                  <!--        <th width="8%">추천</th>
                     -->        <!--th width="8%">첨부</th-->
               </tr>
               </thead>
            <tbody>
               <c:forEach var="item" items="${boardList}">
                  <tr style="">
                     <td align="center"></td>
                     <td align="center" height="38">${item.idno}</td>
                     <th align="left" style="padding-left:10px; word-break:break-all;">
                        <a href="/community/view?idno=${item.idno}">${item.title}</a>         </th>
                     <td align="center">${item.userid}</td>
                     <td align="center">${item.date}</td>
                     <td align="center">${item.view}</td>
                     <!--    <td align="center">0</td>
                     -->    <!--td align="center"></td-->
                  </tr>
               </c:forEach>
            </tbody>
            </table>
            <!-- 게시물 끝 -->   
<!-- 검색 -->
<!-- <div class="AWbbs_f_search">
	<table width="0%" border="0" cellpadding="0" cellspacing="0" align="center">
        <form name="sfrm" action="/sub/sub07_01.html"></form>
        <input type="hidden" name="code" value="notice">
        <input type="hidden" name="category" value="">
        <tbody><tr>
        	<td>
                <select name="searchopt">
                <option value="subject">제 목</option>
                <option value="content">내 용</option>
                <option value="subcon">제목 + 내용</option>
                <option value="name">작성자</option>
                <option value="memid">아이디</option>
                </select>	
                <script language="javascript">
                searchopt = document.sfrm.searchopt;
                for(ii=0; ii<searchopt.length; ii++){
                if(searchopt.options[ii].value == "")
                searchopt.options[ii].selected = true;
                }
                </script>
            </td>
            <td><input name="searchkey" type="text" value=""></td>
            <td><button type="submit">검색</button></td>
        </tr>
        
	</tbody></table> 
</div> -->
<!-- 검색 끝 -->                                                 

<!-- 버튼 -->
<div >
   <div class="col-sm-12 col-md-7" style="display: flex; justify-content: center;">
      <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
         <ul class="pagination" style="display: flex;" >
         
            <c:if test="${pageVO.prev}">
               <li class="paginate_button page-item previous" id="dataTable_previous">
                     <a href="javascript:void(0);" onclick="fn_go_page(${pageVO.startDate - 1}); return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
               </li>
            </c:if>
               
            <c:forEach var="num" begin="${pageVO.startDate}" end="${pageVO.endDate}">
               <li class="paginate_button page-item">
                     <a href="javascript:void(0);" onclick="fn_go_page(${num}); return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">${num}</a>
               </li>
            </c:forEach>
               
            <c:if test="${pageVO.next}">
               <li class="paginate_button page-item next" id="dataTable_next">
                     <a href="javascript:void(0);" onclick="fn_go_page(${pageVO.endDate + 1}); return false;" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Next</a>
               </li>
            </c:if>
         </ul>
      </div>
   </div>   
</div>
<style>
   .paginate_button{
      margin-right: 20px;
   }
</style>

      <!-- Paging[e] -->
      <form method="get"  id="listForm" action="/community/page"  >
         <input type="hidden" id="pageIndex" name="pageIndex" val="" />
      </form>
      <script>
         function fn_go_page(pageNo) {
         $("#pageIndex").val(pageNo);
         $("#listForm").submit();
         return false;
      }
      </script>
<!-- 버튼 끝 -->


                    </div>
                </div>
            </div>
        </div>
        <!-- contents_detail start -->
    </div>
</body>
</html>