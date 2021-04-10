package com.learning.hermes.exceptions;

public class UserCreateException extends RuntimeException{

    public UserCreateException(String message) {
        super(message);
    }
}
