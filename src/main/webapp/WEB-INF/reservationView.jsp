<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<style>
    /* The Modal (background) */
    .searchModal {
        display: none; /* Hidden by default */
        position: fixed; /* Stay in place */
        z-index: 10; /* Sit on top */
        left: 0;
        top: 0;
        width: 100%; /* Full width */
        height: 100%; /* Full height */
        overflow: auto; /* Enable scroll if needed */
        background-color: rgb(0,0,0); /* Fallback color */
        background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    }
 
    /* Modal Content/Box */
    .search-modal-content {
        background-color: #fefefe;
        margin: 5% auto; /* 15% from the top and centered */
        padding: 20px;
        border: 1px solid #888;
        width: 70%; /* Could be more or less, depending on screen size */
    }
</style>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div id="modal" class="searchModal">
        <div class="search-modal-content">
            <div class="page-header">
                <h1>공지사항</h1>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="row">
                        <div class="col-sm-12">
                            <h2>${vo.dtlcont}</h2>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
            <div style="cursor:pointer;background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px;" onClick="closeModal();">
                <span class="pop_bt modalCloseBtn" style="font-size: 13pt;">
                </span>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        jQuery(document).ready(function () {
             $("#modal").show();
        });
        function closeModal() {
            $('.searchModal').hide();
        };
    </script>

    <div id="container" style="width: 1080px; margin: 0 auto;" >
    <h3>${vo.svcnm}</h3>
    <table>
        <ul>
            <li>대상 : ${vo.usetgtinfo}</li>
            <li>지역 : ${vo.areanm}</li>
            <li>장소 : ${vo.placenm}</li>
            <li>용도 : ${vo.minclassnm}</li>
            <li>번호: ${vo.telno}</li>
            <li>예약현황 : ${vo.svcstatnm}</li>
        </ul>
        <ul>
            <li><a href="/reservation?svc=${vo.svcid}">예약결제하기</a></li>
        </ul>
    </table>

    <table style="width: 1080px;" >
        <colgroup>
            <col style="width: 30%;">
            <col style="width:70%">
        </colgroup>
        <h3>신청자 정보</h3>
        <tbody>
            <tr>
                <th>이름</th>
                <td>name</td>
            </tr>
            <tr>
                <th>이름</th>
                <td>name</td>
            </tr>
            <tr>
                <th>전화</th>
                <td>name</td>
            </tr>
            <tr>
                <th>휴대폰</th>
                <td>name</td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>name</td>
            </tr>
            <tr>
                <th>주소</th>
                <td>name</td>
            </tr>
            <tr>
                <th>거주지역인증</th>
                <td>name</td>
            </tr>
        </tbody>
    </table>

</div>
    
</body>
</html>