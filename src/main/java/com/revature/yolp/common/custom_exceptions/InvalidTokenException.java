package com.revature.yolp.common.custom_exceptions;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException() {
        super();
    }

    public InvalidTokenException(String message) {
        super(message);
    }
}
