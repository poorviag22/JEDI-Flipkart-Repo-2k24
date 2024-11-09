package com.flipfit.exceptions;

public class DataEntryFailedException extends Exception {
    public DataEntryFailedException(String message) {
        super(message);
    }
    public DataEntryFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
