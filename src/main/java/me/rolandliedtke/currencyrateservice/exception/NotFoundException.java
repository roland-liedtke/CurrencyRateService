package me.rolandliedtke.currencyrateservice.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ExceptionEvent {

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public String getErrorMessage() {
        return "404 Nie znalazłem takiej waluty";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}