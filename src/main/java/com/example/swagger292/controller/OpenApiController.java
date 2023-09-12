package com.example.swagger292.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger292.dao.TennisDao;
import com.example.swagger292.dto.TennisDTO;
import com.example.swagger292.service.TennisService;
import com.mysql.cj.xdevapi.JsonParser;

@RestController
@RequestMapping("open-api")
public class OpenApiController {

    // private final OpenApiManager openApiManager;
    // public OpenApiController(OpenApiManager openApiManager) {
    //     this.openApiManager = openApiManager;
    // }

    // @GetMapping("open-api")
    // public ResponseEntity<?> fetch() throws UnsupportedEncodingException {
    //     return success(openApiManager.fetch().getBody());
    // }

    //생성자 주입
    private final TennisService tennisvc;
    public OpenApiController(TennisService tennisvc) {
        this.tennisvc = tennisvc;
    }

    // public OpenApiController(){

    //     try {
    //     StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
	// 	urlBuilder.append("/" +  URLEncoder.encode("626247706f6b796a37336475594765","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
	// 	urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
	// 	urlBuilder.append("/" + URLEncoder.encode("ListPublicReservationSport","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
	// 	urlBuilder.append("/" + URLEncoder.encode("1","UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
	// 	urlBuilder.append("/" + URLEncoder.encode("2","UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
	// 	// 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
		
	// 	// 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
	// 	urlBuilder.append("/" + URLEncoder.encode("테니스장","UTF-8")); /* 서비스별 추가 요청인자들*/
		
	// 	URL url = new URL(urlBuilder.toString()); //urlBuilder를 url로 저장함. 
	// 	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	// 	conn.setRequestMethod("GET");
	// 	conn.setRequestProperty("Content-type", "application/json");
	// 	// System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
	// 	BufferedReader rd;

	// 	// 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
	// 	if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	// 			rd = new BufferedReader(new InputStreamReader(conn.getInputStream())); //rd에 conn.getResponseCode값을 저장한다.
	// 	} else {
	// 			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	// 	}
	// 	StringBuilder sb = new StringBuilder();
	// 	String line;
	// 	while ((line = rd.readLine()) != null) {
	// 			sb.append(line); //rd가 null이 아니라면 sb에 더한다. 
                
	// 	}
	// 	rd.close();
	// 	conn.disconnect();
	// 	// System.out.println(sb.toString());

    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }


    @GetMapping("/tennis")
    public String tennis(){

        StringBuffer result = new StringBuffer();

        String jsonPrintString = null;

        try {
            StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088"); /*URL*/
            urlBuilder.append("/" +  URLEncoder.encode("626247706f6b796a37336475594765","UTF-8") ); /*인증키 (sample사용시에는 호출시 제한됩니다.)*/
            urlBuilder.append("/" +  URLEncoder.encode("json","UTF-8") ); /*요청파일타입 (xml,xmlf,xls,json) */
            urlBuilder.append("/" + URLEncoder.encode("ListPublicReservationSport","UTF-8")); /*서비스명 (대소문자 구분 필수입니다.)*/
            urlBuilder.append("/" + URLEncoder.encode("1","UTF-8")); /*요청시작위치 (sample인증키 사용시 5이내 숫자)*/
            urlBuilder.append("/" + URLEncoder.encode("5","UTF-8")); /*요청종료위치(sample인증키 사용시 5이상 숫자 선택 안 됨)*/
            // 상위 5개는 필수적으로 순서바꾸지 않고 호출해야 합니다.
            
            // 서비스별 추가 요청 인자이며 자세한 내용은 각 서비스별 '요청인자'부분에 자세히 나와 있습니다.
            urlBuilder.append("/" + URLEncoder.encode("테니스장","UTF-8")); /* 서비스별 추가 요청인자들*/
            
            URL url = new URL(urlBuilder.toString()); //urlBuilder를 url로 저장함. 
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        
            urlConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));

            String returnLine;
            while((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);
            }
            jsonPrintString = result.toString();
            
            //build.gradle json추가
            // JSONObject json = new JSONObject(jsonPrintString);
            // System.out.println("json"+json);
            // String MAXCLASSNM = json.getJSONObject("ListPublicReservationSport").getJSONArray("row").getString(1);
            // System.out.println("체육시설 "+MAXCLASSNM);

            JSONObject obj = new JSONObject(jsonPrintString);
            JSONObject listPublicReservationSport = obj.getJSONObject("ListPublicReservationSport");
            JSONArray row = listPublicReservationSport.getJSONArray("row");

            for (int i = 0; i < row.length(); i++) {
                String svcstatnm = row.getJSONObject(i).getString("SVCSTATNM"); // 서비스 상태
                String usetgtinfo = row.getJSONObject(i).getString("USETGTINFO"); // 서비스 대상 정보
                String gubun = row.getJSONObject(i).getString("GUBUN"); // 서비스 구분
                String rcptenddt = row.getJSONObject(i).getString("RCPTENDDT"); // 접수 종료 일시
                String svcopnenddt = row.getJSONObject(i).getString("SVCOPNENDDT"); // 서비스 개시 종료 일시
                String svcid = row.getJSONObject(i).getString("SVCID"); // 서비스 ID
                String v_max = row.getJSONObject(i).getString("V_MAX"); // 서비스 이용 종료 시간
                String v_min = row.getJSONObject(i).getString("V_MIN"); // 서비스 이용 시작 시간
                String telno = row.getJSONObject(i).getString("TELNO"); // 전화번호
                String minclassnm = row.getJSONObject(i).getString("MINCLASSNM"); // 소분류명 
                String payatnm = row.getJSONObject(i).getString("PAYATNM"); // 결제 방법
                String svcurl = row.getJSONObject(i).getString("SVCURL"); // 바로가기 URL
                String revstddaynm = row.getJSONObject(i).getString("REVSTDDAYNM"); // 취소 기간 기준 정보
                int revstdday = row.getJSONObject(i).getInt("REVSTDDAY"); // 취소 기간 기준일까지
                String placenm = row.getJSONObject(i).getString("PLACENM"); // 장소명
                String dtlcont = row.getJSONObject(i).getString("DTLCONT"); // 상세 정보
                String areanm = row.getJSONObject(i).getString("AREANM"); // 지역명
                String rcptbgndt = row.getJSONObject(i).getString("RCPTBGNDT"); // 접수 시작 일시
                String svcopnbgndt = row.getJSONObject(i).getString("SVCOPNBGNDT"); // 서비스 개시 시작 일시 
                String svcnm = row.getJSONObject(i).getString("SVCNM");  // 서비스명 
                String y = row.getJSONObject(i).getString("Y");  // 장소 Y 좌표 
                String imgurl = row.getJSONObject(i).getString("IMGURL"); //이미지 경로
                String maxclassnm = row.getJSONObject(i).getString("MAXCLASSNM"); //대분류명
                String x = row.getJSONObject(i).getString("X"); //장소 X 좌표
                // System.out.println("1: "+maxClassNm);
                // System.out.println("2:"+SVCNM);
                // 이제 maxClassNm 변수를 원하는 대로 사용할 수 있습니다.
                // 예를 들어, ArrayList에 추가하거나 데이터베이스에 저장할 수 있습니다.
                // TennisDTO.

                TennisDTO dto = new TennisDTO();
                dto.setSvcstatnm(svcstatnm);
                dto.setUsetgtinfo(usetgtinfo);
                dto.setGubun(gubun);
                dto.setRcptenddt(rcptenddt);
                dto.setSvcopnenddt(svcopnenddt);
                dto.setSvcid(svcid);
                dto.setV_max(v_max);
                dto.setV_min(v_min);
                dto.setTelno(telno);
                dto.setMinclassnm(minclassnm);
                dto.setPayatnm(payatnm);
                dto.setSvcurl(svcurl);
                dto.setRevstddaynm(revstddaynm);
                dto.setRevstdday(revstdday);
                dto.setPlacenm(placenm);
                dto.setDtlcont(dtlcont);
                dto.setAreanm(areanm);
                dto.setRcptbgndt(rcptbgndt);
                dto.setSvcopnbgndt(svcopnbgndt);
                dto.setSvcnm(svcnm);
                dto.setY(y);
                dto.setImgurl(imgurl);
                dto.setMaxclassnm(maxclassnm);
                dto.setX(x);
                tennisvc.saveTennis(dto);

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonPrintString;
    }


    
}
