// 댓글 저장
function saveComment() {
                                            
    const content = document.getElementById('content').value;
    const postId = document.getElementById('postId').value;
    const loginId = document.getElementById('loginId').value;
    const commid = document.getElementById('commid').value;
    const params = {
        // postId : postId,
        content : content,
        userno : loginId,
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

            // 1. 조회된 데이터가 없는 경우
            if ( !data.length ) {
                document.querySelector('.cm_list').innerHTML = '<div class="cm_none"><p>등록된 댓글이 없습니다.</p></div>';
                return false;
            }

            // 2. 렌더링 할 HTML을 저장할 변수
            let commentHtml = '';
            var cCnt = data.length;

            // 3. 댓글 HTML 추가
            if(data.length > 0){
                for(i=0; i<data.length; i++){
                    commentHtml += "<div>";
                    commentHtml += "<p class='writer'><em>"+data[i].userid+"</em><span class='date'>"+data[i].time+"</span></p>";
                    commentHtml += "<div class='cont'><div class='txt_con'>"+data[i].content+"</div></div>";
                    commentHtml += "<p class='func_btns'>";
                    commentHtml += "<button type='button' class='btns'><span class='icons icon_modify'>수정</span></button>";
                    commentHtml += "<button type='button' class='btns'><span class='icons icon_del'>삭제</span></button>";          
                    commentHtml += "</p></div>";
                }
            }
            $("#cCnt").html(cCnt);
            $(".cm_list").html(commentHtml);

            // 4. class가 "cm_list"인 요소를 찾아 HTML을 렌더링
            document.querySelector('.cm_list').innerHTML = commentHtml;
            
            // var html = "";
            // var cCnt = data.length;
            
            // if(data.length > 0){
                
            //     for(i=0; i<data.length; i++){
            //         html += "<div>";
            //         html += "<div><table class='table'><h6><strong>"+data[i].userid+"</strong></h6>";
            //         html += data[i].content + "<tr><td></td></tr>";
            //         html += "</table></div>";
            //         html += "</div>";
            //     }
                
            // } else {
                
            //     html += "<div>";
            //     html += "<div><table class='table'><h6><strong>등록된 댓글이 없습니다.</strong></h6>";
            //     html += "</table></div>";
            //     html += "</div>";
                
            // }
            
            // $("#cCnt").html(cCnt);
            // $("#commentList").html(html);
            
        },
        error:function(request,status,error){
            
    }
        
    });
}