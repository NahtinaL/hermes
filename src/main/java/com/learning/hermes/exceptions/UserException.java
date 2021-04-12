package com.learning.hermes.exceptions;

import org.springframework.http.HttpStatus;

public class UserException extends RuntimeException {

    private HttpStatus status;

    public UserException (HttpStatus httpStatus, String message) {
        super(message);
        this.status = httpStatus;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
