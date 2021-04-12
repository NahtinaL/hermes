package com.learning.hermes.exceptions;

import com.learning.hermes.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(value = {UserException.class})
    public ResponseEntity<Object> handleUserExceptions (UserException exception, WebRequest request) {
        exception.printStackTrace();

        ErrorMessage errorMessage = new ErrorMessage(new Date(), exception.getMessage(), exception.getStatus().toString());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), exception.getStatus());
    }
}
