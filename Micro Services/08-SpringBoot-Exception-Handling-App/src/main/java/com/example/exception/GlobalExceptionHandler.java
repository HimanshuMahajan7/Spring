package com.example.exception;

import com.example.response.ExceptionInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<ExceptionInfo> handleCustomerNotFound(CustomerNotFoundException ex) {
        ExceptionInfo response = ExceptionInfo
                .builder()
                .code("XXX")
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
