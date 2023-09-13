<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카카오지도 api study</title>
</head>

<body>
    <div id="map" style="width: 1000px; height: 700px;"></div> 
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=98492dd7f33496409be5e616fd471e95"></script>
	<!-- services와 clusterer, drawing 라이브러리 불러오기 -->
<!-- <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=98492dd7f33496409be5e616fd471e95&libraries=clusterer,drawing"></script> -->
	
	<script type="text/javascript">
	
	var mapContainer = document.getElementById('map');
	var mapOption = {
		center: new kakao.maps.LatLng(37.658042, 127.044202),
		level: 3
	};

	var map = new kakao.maps.Map(mapContainer, mapOption);

	// 마커와 인포윈도우를 관리할 배열
	var markers = [];
	var infowindows = [];

	// 마커 정보를 정의한 데이터 배열
	var markerData = [
		{
			title: '우리집',
			latlng: new kakao.maps.LatLng(37.658042, 127.044202),
			content: '우리집에 오신 것을 환영합니다.'
		},
		{
			title: '보라매공원>테니스장',
			latlng: new kakao.maps.LatLng(37.49101, 126.91605),
			content: '보라매공원 테니스장입니다.'
		},
		{
			title: '응봉공원',
			latlng: new kakao.maps.LatLng(37.5569473910838, 127.02182026085195),
			content: '응봉공원에 오신 것을 환영합니다. <a href="https://map.kakao.com/?urlX=504820.0&urlY=1127062.0&name=%EC%9D%91%EB%B4%89%EA%B3%B5%EC%9B%90" target="_blank">자세히 보기</a>'
		}
	];

	// 마커 생성 및 클릭 이벤트 등록
	for (var i = 0; i < markerData.length; i++) {
		var marker = new kakao.maps.Marker({
			position: markerData[i].latlng,
			clickable: true
		});

		var infowindow = new kakao.maps.InfoWindow({
			content: markerData[i].title,
			removable: true
		});

		markers.push(marker);
		infowindows.push(infowindow);

		kakao.maps.event.addListener(marker, 'click', makeClickListener(map, marker, infowindow));
		marker.setMap(map);
	}

	// 클릭 이벤트 핸들러 생성 함수
	function makeClickListener(map, marker, infowindow) {
		return function () {
			// 해당 마커 위에 인포윈도우를 표시
			infowindow.open(map, marker);
		};
	}

		
	
	</script>
</body>
</html>