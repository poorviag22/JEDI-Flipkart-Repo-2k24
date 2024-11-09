package com.flipfit.exceptions;

public class UnauthorisedAccessException extends Exception {

    public UnauthorisedAccessException(String message) {
        super(message);
    }
    public UnauthorisedAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}