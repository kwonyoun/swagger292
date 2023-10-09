<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<jsp:include page="header.jsp"/>
<body>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="AWbbs_view_table border">
        <input type="hidden" value=${vo.userid} id="postId">
        <input type="hidden" value="${pageContext.request.userPrincipal.name}" id="loginId" >
        <input type="hidden" value="${vo.idno}" id="commid">
        
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
                                    <span><strong>Comments</strong></span> <span id="cCnt"></span>
                                    <div id="commentList">
                                    </div>
                                    <script>
                                        // 댓글 저장
                                        function saveComment() {
                                            
                                            const content = document.getElementById('content').value;
                                            const postId = document.getElementById('postId').value;
                                            const loginId = document.getElementById('loginId').value;
                                            const commid = document.getElementById('commid').value;
                                            const params = {
                                                postId : postId,
                                                content : content,
                                                userid : loginId,
                                                commid : commid
                                            }

                                            $.ajax({
                                                url : `/comments`,  
                                                type : 'post',
                                                contentType : 'application/json; charset=utf-8',
                                                data : JSON.stringify(params),
                                                success: function(data) {
                                                    alert("댓글을 등록하였습니다.");
                                                    getCommentList();                                              
                                                },
                                                error: function(xhr, status, error) {
                                                    console.error(error);
                                                    alert("댓글 등록에 실패하였습니다.");
                                                }
                                            })
                                        }

                                        /**
                                        * 댓글 불러오기(Ajax)
                                        */
                                        window.onload = () => {
                                            getCommentList();
                                        }
                                        function getCommentList(){
                                            const commid = document.getElementById('commid').value;
                                            // alert("getlist: "+commid);
                                            
                                            $.ajax({
                                                type:'GET',
                                                url : `/comments/`+commid,
                                                data:commid,
                                                contentType: "application/json; charset=UTF-8", 
                                                success : function(data){
                                                    
                                                    var html = "";
                                                    var cCnt = data.length;
                                                    
                                                    if(data.length > 0){
                                                        
                                                        for(i=0; i<data.length; i++){
                                                            html += "<div>";
                                                            html += "<div><table class='table'><h6><strong>"+data[i].userid+"</strong></h6>";
                                                            html += data[i].content + "<tr><td></td></tr>";
                                                            html += "</table></div>";
                                                            html += "</div>";
                                                        }
                                                        
                                                    } else {
                                                        
                                                        html += "<div>";
                                                        html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
                                                        html += "</table></div>";
                                                        html += "</div>";
                                                        
                                                    }
                                                    
                                                    $("#cCnt").html(cCnt);
                                                    $("#commentList").html(html);
                                                    
                                                },
                                                error:function(request,status,error){
                                                    
                                            }
                                                
                                            });
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