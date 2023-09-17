<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
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
            <li><a href="/reservation?svc=${vo.svcid}"></li>
        </ul>
    </table>
    <div style="width: 1080px;" ><div id="map" style="width: 800px; height: 500px; margin: 0 auto; "></div></div> 
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=98492dd7f33496409be5e616fd471e95"></script>
    <script type="text/javascript">
	
        var mapContainer = document.getElementById('map');
        var mapOption = {
            center: new kakao.maps.LatLng(${vo.x}, ${vo.y}),
            level: 3
        };
    
        var map = new kakao.maps.Map(mapContainer, mapOption);

        // 마커가 표시될 위치입니다 
        var markerPosition  = new kakao.maps.LatLng(${vo.x}, ${vo.y}); 
    
        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({   
            position: markerPosition
        });

        // 마커가 지도 위에 표시되도록 설정합니다
        marker.setMap(map);

        // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
        // marker.setMap(null);    
        </script>
</div>
    
</body>
</html>