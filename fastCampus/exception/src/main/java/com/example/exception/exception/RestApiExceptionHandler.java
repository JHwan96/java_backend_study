package com.example.exception.exception;

import com.example.exception.controller.RestApiAController;
import com.example.exception.controller.RestApiBController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice(basePackages = "com.example.exception.controller")
@RestControllerAdvice(basePackageClasses = {RestApiAController.class, RestApiBController.class})
@Slf4j
public class RestApiExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(Exception e){
        log.error("RestApiExceptionHandler",e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(IndexOutOfBoundsException e){
        log.error("IndexOutOfBoundsException ", e);
        return ResponseEntity.status(200).build();
    }
}
