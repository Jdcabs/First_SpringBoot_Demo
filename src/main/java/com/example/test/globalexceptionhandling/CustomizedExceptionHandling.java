package com.example.test.globalexceptionhandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler{
    

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleExceptions( CustomerNotFoundException exception, WebRequest webRequest) {
        RespondRequest response = new RespondRequest();
        response.setMessage(" ID Not Found");
        response.setLocalDate(LocalDateTime.now());

        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(CustomerNotCreatedException.class)
    public ResponseEntity<Object> handleExceptions ( CustomerNotCreatedException exception, WebRequest webRequest) {
        RespondRequest respondRequest = new RespondRequest();
        respondRequest.setMessage("Customer not created, some problems accured, please check it carefully");
        respondRequest.setLocalDate(LocalDateTime.now());

        ResponseEntity<Object> entity = new ResponseEntity<>(respondRequest, HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }
}
