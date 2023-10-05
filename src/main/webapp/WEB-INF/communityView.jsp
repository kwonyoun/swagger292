<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="AWbbs_view_table border">
        <input type="hidden" value=${vo.userid} id="postId">
        <input type="hidden" value="${pageContext.request.userPrincipal.name}" id="loginId"
        <tbody>
            <tr>
                <th colspan="2">${vo.title}</th>
            </tr>
            <tr>
                    <td height="40">작성자 : ${vo.userid} 작성일 : ${vo.date} 조회수 : ${vo.view}</td>
                    <td align="right"><!--추천 : 0--></td>
            </tr>
            
                <tr>
                <td colspan="2" height="40">파일첨부 :             </td>
            </tr>
            <tr>
                <td colspan="2" style="padding:20px 16px;">
                    <table border="0" cellspacing="0" cellpadding="0" style="width:600px;height:0px;" id="wiz_get_table_width">
                        <colgroup><col width="100%">
                        </colgroup>
                        <tbody>
                            <tr>
                        <td></td>
                        </tr>
                        </tbody>
                    </table>
                    
                    <table border="0" cellspacing="0" cellpadding="0" width="100%">
                        <colgroup><col width="100%"></colgroup>
                        <tbody>
                            <tr>
                                <td valign="top">
                                    <p style="text-align: center; " align="center">
                                        
                                    </p> 
                                    <input type="text" id="content" value="" >
                                    <button onclick="saveComment()">댓글작성</button>
                                    
                                    <script>
                                        // 댓글 저장
                                        function saveComment() {
                                            
                                            const content = document.getElementById('content').value;
                                            const postId = document.getElementById('postId').value;
                                            const loginId = document.getElementById('loginId').value;
                                            alert(content+"/"+postId+"/"+loginId);
                                            const params = {
                                                postId : postId,
                                                content : content,
                                                userid : loginId
                                            }

                                            $.ajax({
                                                url : `/comments`,
                                                type : 'post',
                                                contentType : 'application/json; charset=utf-8',
                                                dataType : 'json',
                                                data : JSON.stringify(params),
                                                async : false,
                                                success : function (response) {
                                                    console.log(response);
                                                },
                                                error : function (request, status, error) {
                                                    console.log(error)
                                                }
                                            })
                                    }
                                    </script>
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