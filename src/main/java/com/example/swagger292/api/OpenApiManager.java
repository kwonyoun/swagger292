package com.example.swagger292.api;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenApiManager {
    private final String BASE_URL = "http://openapi.seoul.go.kr:8088";
    private final String serviceKey = "/626247706f6b796a37336475594765";
    private final String type = "/json";
    private final String service = "/ListPublicReservationSport";
    private final String numOfRows = "/1";
    private final String areaCode = "/2";
    private final String contentTypeId = "테니스장";


    private String makeUrl() throws UnsupportedEncodingException {
        return BASE_URL +
                serviceKey +
                type +
                service +
                numOfRows +
                areaCode +
                contentTypeId;
    }

    public ResponseEntity<?> fetch() throws UnsupportedEncodingException {
        System.out.println(makeUrl());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = new HttpEntity<>(new HttpHeaders());
        ResponseEntity<Map> resultMap = restTemplate.exchange(makeUrl(), HttpMethod.GET, entity, Map.class);
        System.out.println(resultMap.getBody());
        return resultMap;

    }
}