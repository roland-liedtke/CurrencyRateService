package me.rolandliedtke.currencyrateservice.exception;

import org.springframework.http.HttpStatus;

public abstract class ExceptionEvent extends RuntimeException {
    public ExceptionEvent(String message) {
        super(message);
    }

    public abstract String getErrorMessage();

    public abstract HttpStatus getHttpStatus();
}