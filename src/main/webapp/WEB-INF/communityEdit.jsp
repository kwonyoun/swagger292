<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>커뮤니티 수정</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div style="margin-top: 100px;" >
        <form action="/community/edit/${vo.commid}" method="post" >
            <div class="board_wrap">
                <div class="board_title">
                    <strong>문의 수정하기</strong>
        
                </div>
                <div class="board_write_wrap">
                    <div class="board_write">
                        <input type="text" value=${vo.commid} name="commid" hidden="hidden">
                        <div class="title">
                            <dl>
                                <dt>제목</dt>
                                <dd><input name="title" type="text" value=${vo.title} class="title"></dd>
                            </dl>
                        </div>
                        
                        <div class="info">
                            <dl>
                                <dt>글쓴이</dt>
                                <dd><input name="userid" id="userid" type="text" value=${vo.userid} class="writer" readonly="readonly" onselectstart="return false;" onmousedown="return false;"></dd>
                            </dl>
                            
                        </div>
                        
                        <div class="cont">
                            <textarea  name="content">${vo.content}</textarea>
                        </div>
                    </div>
                    <div class="bt_wrap">
                        <input type="submit" value="수정">
                        <a href="/community/view?commid=${vo.commid}">취소</a>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>