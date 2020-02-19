package com.northwind.catalogservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Configuration
public class ExceptionHandlerAdvice {

    @ExceptionHandler(IllegalAccessException.class)
    public ResponseEntity<String> handleIllegalAccess(){
        return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
    }
}
