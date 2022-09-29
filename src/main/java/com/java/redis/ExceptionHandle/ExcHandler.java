package com.java.redis.ExceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExcHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> runTimeExc(RuntimeException e){
        ErrorResponse response=new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
