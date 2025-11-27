package com.gergert.task1.exception;

public class CustomException extends Exception {
    public CustomException (String exception){
        super(exception);
    }

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
