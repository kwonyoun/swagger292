<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="AWbbs_view_table border">
        <tbody>
            <tr>
                <th colspan="2">${vo.title}</th>
            </tr>
            <tr>
                    <td height="40">작성자 : 4시즌 테니스 아카데미(test@test.com) 작성일 : ${vo.date} 조회수 : ${vo.view}</td>
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
                        <colgroup><col width="100%">
                        </colgroup><tbody><tr><td valign="top"><p style="text-align: center; " align="center"><img name="wiz_target_resize" style="cursor:pointer" onclick="window.open(this.src)" src="/adm/data/webedit/20230921111026351947776.jpg" title="popup01.jpg"><br style="clear:both;">&nbsp;</p> </td></tr>
                        </tbody>
                    </table>		
                </td>
            </tr>
        
        </tbody>
    </table>
</body>
</html>