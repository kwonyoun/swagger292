<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
</head>
<jsp:include page="header.jsp"/>
<body style="font-family: Noto Sans KR,sans-serif;" >
    
    <div style="width: 1080px; margin: 100px auto 20px auto" >
        <div style="width: 750px;margin: 0 auto;">
			<!-- <img src="/imgs/branch-bn.jpg" style="width: 800px; height: 200px ;" > -->
			<div style="background-image: url('imgs/branch-bn.jpg'); width: 750px; height: 150px;" >
				<div style="background-color: rgba(120, 121, 120, 0.89); width: 100%;height: 100%;" >
					<div style="font-size: 2em;line-height: 6;text-align: end;padding-right: 50px;color: white;" >Top Tennis 지점 소개</div>
				</div>
			</div>
		</div>
    </div>
	
	<div id="wrap" style="display: flex;flex-direction: row-reverse; width: 1500px;margin: 0 auto;" >
		<div id="branch-list" style="overflow-y: scroll; max-height: 600px; margin-left: 20px;" >
			<c:forEach var="item" items="${vo}">
				<div id="list-wrap" style="border-style: solid;border-color: #e5e7eb;">
					<tr>
						<h4><a href="${item.url}">${item.branch}</a></h4>
						<a>${item.tel}</a><br>
						<a>${item.address}</a>
					</tr>
				</div>
			</c:forEach>
		</div>


		

		<div id="map-wrap" style="width: 1100px;" >
			<div id="map" style="width: 1100px; height: 600px; margin: 0 auto;"></div> 
		</div>
	</div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=98492dd7f33496409be5e616fd471e95"></script>
	<script type="text/javascript">
	
	var mapContainer = document.getElementById('map');
	var mapOption = {
		center: new kakao.maps.LatLng(37.658042, 127.044202),
		level: 10
	};

	var map = new kakao.maps.Map(mapContainer, mapOption);

	// 마커와 인포윈도우를 관리할 배열
	var markers = [];
	var infowindows = [];

	// 마커 정보를 정의한 데이터 배열
	// var markerData = []; // 서버에서 받아온 데이터를 저장할 변수

	// Ajax를 사용하여 서버에서 데이터를 받아옴
	$.ajax({
		url: '/map/branch', // 컨트롤러 메서드의 URL
		type: 'GET',
		dataType: 'json', // 서버에서 받아온 데이터를 JSON으로 처리
		success: function(markerData) {
			// 성공적으로 데이터를 받았을 때 실행되는 함수
			// markerData = data; // 서버에서 받아온 데이터를 사용
			// alert(markerData[0].placenm);
			// alert(markerData[0].x);
			// alert(markerData[0].y);

			// 클릭 상태를 관리하기 위한 배열
	var clickStatus = [];

// 마커 생성 및 클릭 이벤트 등록
for (var i = 0; i < markerData.length; i++) {
	var marker = new kakao.maps.Marker({
		position: new kakao.maps.LatLng(markerData[i].x, markerData[i].y),
		clickable: true
	});

	var infowindow = new kakao.maps.InfoWindow({
		content: '<div style="padding:5px;">'+markerData[i].branch+'<br>'+markerData[i].address+'</div>',
		removable: true
	});

	// markers.push(marker); //변수marker에 저장된 객체를 배열markers에 저장한다. 모든 마커를 한 번에 지도에서 제거하거나 모든 마커를 숨기는 작업을 수행할 때 유용합니다.
	// infowindows.push(infowindow); //변수 infowindow에 저장된 객체를 배열 infowindows에 저장한다. 모든 인포윈도우를 닫는 작업이나 모든 인포윈도우의 내용을 변경하는 작업에 유용합니다.
	clickStatus.push(false); // 초기 클릭 상태를 모두 false로 설정

	kakao.maps.event.addListener(marker, 'click', makeClickListener(map, marker, infowindow, i));
	
	marker.setMap(map);

	// 클릭 이벤트 핸들러 생성 함수
	function makeClickListener(map, marker, infowindow, index) {
		return function () {
			// 클릭 상태에 따라 인포윈도우를 열거나 닫음
			if (clickStatus[index]) {
				infowindow.close();
			} else {
				infowindow.open(map, marker);
			}
			
			// 클릭 상태를 토글
			clickStatus[index] = !clickStatus[index];
		};
	}

}

			// markerData 배열을 이용하여 지도 마커 생성 등의 작업 수행
			// 예: markerData[0].title, markerData[0].latlng 등을 사용하여 마커 생성
		},
		error: function() {
			// 데이터를 받아오는데 실패한 경우 실행되는 함수
			console.error('데이터를 가져오는 데 실패했습니다.');
		}
	});

	

	

		
	
	</script>
</body>
</html>