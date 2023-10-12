<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="/js/comments.js"></script>
    <link rel="stylesheet" href="/css/comments.css"></link>
</head>
<jsp:include page="header.jsp"/>
<body>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="AWbbs_view_table border" style="margin-top: 100px;" >
        <input type="hidden" value=${vo.userno} id="postId">
        <input type="hidden" value="${pageContext.request.userPrincipal.name}" id="loginId" >
        <input type="hidden" value="${vo.commid}" id="commid">
        
        <tbody>
            <tr>
                <th colspan="2">${vo.title}</th>
            </tr>
            <tr>
                    <td height="40">작성자 : ${vo.userid}  </td>
                    <td height="40">작성일 : ${vo.date}</td>
                    <td height="40">조회수 : ${vo.view}</td>
                    <td height="40">${vo.content}</td>
                    <td align="right">
                        <button><a href="/community/edit/${vo.commid}">수정</a></button>
                    </td>
            </tr>
            <tr>
                <td colspan="2" style="padding:20px 16px;">
                    
                    <table border="0" cellspacing="0" cellpadding="0" width="100%">
                        <colgroup><col width="100%"></colgroup>
                        <tbody>
                            <tr>
                                <td valign="top">
                                    <p style="text-align: center; " align="center">
                                        
                                    </p>
                                    <input type="text" id="content" value="" > 
                                    <button onclick="saveComment()">댓글작성</button>
                                    <span><strong>Comments</strong></span> <span id="cCnt"></span>

                                    <!--/* 댓글 렌더링 영역 */-->
                                    <div style="margin: 0 auto;" >
                                        <div class="cm_list" style="width: 800px; margin: 0 auto;" ></div>
                                    </div>
                                </td>   
                            </tr>
                        </tbody>
                    </table>		
                </td>
            </tr>
        
        </tbody>
    </table>
</body>
</html>