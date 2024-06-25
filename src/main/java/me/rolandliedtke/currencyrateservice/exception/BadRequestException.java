package me.rolandliedtke.currencyrateservice.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ExceptionEvent {

    public BadRequestException(String message) {
        super(message);
    }

    @Override
    public String getErrorMessage() {
        return "400 Nieprawidłowe zapytanie.";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
