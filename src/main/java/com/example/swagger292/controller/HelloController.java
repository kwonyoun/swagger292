// package com.example.swagger292.controller;

// import java.lang.annotation.Annotation;
// import java.lang.reflect.Method;
// import java.util.HashMap;
// import java.util.Map;

// import io.swagger.annotations.ApiOperation;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import com.example.swagger292.common.annotation.FieldAnnotation;
// import com.example.swagger292.common.annotation.MethodAnnotation;
// import com.example.swagger292.common.annotation.TypeAnnotation;
// // import com.example.swagger292.common.annotation.ValidationAnnotation;
// // import com.example.swagger292.common.valid.TempDto;

// // import javax.validation.Valid;

// @RestController
// // @TypeAnnotation(name = "Hello?", value = "World")
// public class HelloController {
//     // @FieldAnnotation(name = "returnValue", value = "Bye World!")
//     // public String returnValue = "Hello World!";
//     // private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

//     @RequestMapping("/hello")
//     public String hello() {
//         return "Hello World! hello";
//     }
// }