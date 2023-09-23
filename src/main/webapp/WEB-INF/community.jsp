<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <!-- community -->
    <section>
   
         <div class="board_wrap">
         
             <div class="qna_title">
              
                <div id="qna_title_wrap" >
                    <h1 style="font-size: 40px;" >Q&A</h1>
                 <h3 style="font-size: 20px;" >직접 문의하기</h3>
                 
              </div>

                <span>총게시물 ${totCnt} / 페이지 (${pagination.currentPageNo} / ${totalPageCnt})</span>
     
                <div class="bt_wrap" style="float: right; margin-right: 30px;" >
                 <a href="/cscenter/qna/write" class="on" >등록</a>
             </div>
             </div>
             
             <div class="board_list_wrap">
                 <div class="board_list">
                     <div class="top">
                      <!-- <div class="num">번호</div> -->   
                         <div class="num">번호</div>
                         <div class="title">제목</div>
                         <div class="writer">질문자</div>
                         <div class="count">답변상황</div>
                         <div class="date">문의일</div>
                     </div>
     
                    <div>
     
                       <!-- foreach 문으로 컬렉션 반복 처리 -->
                       <c:forEach var="item" items="${boardList}">
                          <div class="num">${item.qnaNum} </div>
                          <div class="title">
                             <a href="/cscenter/qna/view?qnaNum=${item.qnaNum}">${item.qnaTitle}
                                <c:if test="${item.qnaOpen eq 'private'}">
                                <img src="/imgs/lock.png" alt="fail" style="width: 12px; height: 12px;" >
                                </c:if>
                             </a>
                          
                          
                          </div>
                          <div class="writer">${item.qnaMemId}</div>
                          <div class="writer">${item.qnaOpen}</div>
                          <div class="date">${item.qnaDate}</div>
                       </c:forEach>
     
                    </div>
     
     
                    <!-- Paging[s] -->
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
                          <li class="paginate_button page-item" style="border-style: solid;border-width: 2px; width: 20px; height: 30px; line-height: 30px;" >
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
                 <form method="get"  id="listForm" action="/cscenter/qnalist/page"  >
                    <input type="hidden" id="pageIndex" name="pageIndex" val="" />
                 </form>
                 <script>
                    function fn_go_page(pageNo) {
                    $("#pageIndex").val(pageNo);
                    $("#listForm").submit();
                    return false;
                 }
                 </script>
                     
                     
                 
              </div>
           </div>
     
           
          
         
         </section>
</body>
</html>