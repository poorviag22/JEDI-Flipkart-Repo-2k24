package com.flipfit.exception;

public class DBconnectionException extends Exception {

    public DBconnectionException(String message) {
            super(message);
        }
    public DBconnectionException(String message, Throwable cause) {
        super(message, cause);
    }

}
