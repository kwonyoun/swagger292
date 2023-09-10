package com.example.swagger292.controller;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.swagger292.common.annotation.FieldAnnotation;
import com.example.swagger292.common.annotation.MethodAnnotation;
import com.example.swagger292.common.annotation.TypeAnnotation;
// import com.example.swagger292.common.annotation.ValidationAnnotation;
// import com.example.swagger292.common.valid.TempDto;

// import javax.validation.Valid;

@RestController
// @TypeAnnotation(name = "Hello?", value = "World")
public class HelloController {
    // @FieldAnnotation(name = "returnValue", value = "Bye World!")
    // public String returnValue = "Hello World!";
    // private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World! hello";
    }

    // @RequestMapping("/hello1")
    // @MethodAnnotation(name = "Hello1", value = "World1")
    // public String hello1() throws NoSuchMethodException {
    //     Method method = this.getClass().getMethod("hello1");
    //     Annotation[] annotations = method.getDeclaredAnnotations();

    //     for(Annotation annotation: annotations){
    //         if(annotation instanceof MethodAnnotation) {
    //             MethodAnnotation methodAnnotation = (MethodAnnotation) annotation;
    //             return methodAnnotation.name() + ", " + methodAnnotation.value();
    //         }
    //     }
    //     return "Hello World!";
    // }

    // // @RequestMapping("/hello2")
    // // public String hello2(@RequestBody @Valid TempDto dto) {
    // //     return "Valid value : " + dto.getValue();
    // // }

    // @PostMapping("log-test")
    // public void logTest(){

    //     LOGGER.trace("Trace Log");
    //     LOGGER.debug("Debug Log");
    //     LOGGER.info("Info Log");
    //     LOGGER.warn("Warn Log");
    //     LOGGER.error("Error Log");

    // }

    // @PostMapping("/exception")
    // public void exceptionTest() throws Exception {
    //     throw new Exception();
    // }

    // @ExceptionHandler(value = Exception.class)
    // public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
    //     HttpHeaders responseHeaders = new HttpHeaders();
    //     //responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
    //     HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    //     LOGGER.info(e.getMessage());
    //     LOGGER.info("Controller 내 ExceptionHandler 호출");

    //     Map<String, String> map = new HashMap<>();
    //     map.put("error type", httpStatus.getReasonPhrase());
    //     map.put("code", "400");
    //     map.put("message", "에러 발생");

    //     return new ResponseEntity<>(map, responseHeaders, httpStatus);
    // }

}