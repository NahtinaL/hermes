package com.learning.hermes.exceptions;

import com.learning.hermes.model.response.ErrorMessage;
import com.learning.hermes.model.response.ErrorMessages;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
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


        @ExceptionHandler({ConstraintViolationException.class})
        public ResponseEntity<Object> handleBindingErrors(ConstraintViolationException exception) {
            // do whatever you want with the exceptions

            exception.printStackTrace();

            ErrorMessage errorMessage = new ErrorMessage(new Date(), exception.getMessage(),
                    ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
            return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }

}
