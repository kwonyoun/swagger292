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
    <div id="map" style="width: 1600px; height: 850px;"></div> 
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
			content: '보라매공원 테니스장입니다. <a href="/open-api/place?urlX=37.49101&urlY=126.91605" target="_blank">장소 예약현황</a> '
		},
		{
			title: '응봉공원',
			latlng: new kakao.maps.LatLng(37.5569473910838, 127.02182026085195),
			content: '응봉공원에 오신 것을 환영합니다. <a href="/open-api/place?urlX=37.5569473910838&urlY=127.02182026085195" target="_blank">장소 예약현황</a>'
		}
	];

	// 클릭 상태를 관리하기 위한 배열
	var clickStatus = [];

	// 마커 생성 및 클릭 이벤트 등록
	for (var i = 0; i < markerData.length; i++) {
		var marker = new kakao.maps.Marker({
			position: markerData[i].latlng,
			clickable: true
		});

		var infowindow = new kakao.maps.InfoWindow({
			content: '<div style="padding:10px;"><p>'+markerData[i].content+'</p></div>',
			removable: true
		});

		// markers.push(marker); //변수marker에 저장된 객체를 배열markers에 저장한다. 모든 마커를 한 번에 지도에서 제거하거나 모든 마커를 숨기는 작업을 수행할 때 유용합니다.
		// infowindows.push(infowindow); //변수 infowindow에 저장된 객체를 배열 infowindows에 저장한다. 모든 인포윈도우를 닫는 작업이나 모든 인포윈도우의 내용을 변경하는 작업에 유용합니다.
		clickStatus.push(false); // 초기 클릭 상태를 모두 false로 설정

		kakao.maps.event.addListener(marker, 'click', makeClickListener(map, marker, infowindow, i));
		
		marker.setMap(map);
	}

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

		
	
	</script>
</body>
</html>