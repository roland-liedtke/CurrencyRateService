package me.rolandliedtke.currencyrateservice.controller;

import me.rolandliedtke.currencyrateservice.exception.ExceptionEvent;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({ExceptionEvent.class})
    public ResponseEntity<String> handleException(ExceptionEvent exceptionEvent) {
        return ResponseEntity.status(exceptionEvent.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(exceptionEvent.getErrorMessage());
    }
}