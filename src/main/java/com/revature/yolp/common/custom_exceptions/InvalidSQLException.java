package com.revature.yolp.common.custom_exceptions;

public class InvalidSQLException extends RuntimeException {
    public InvalidSQLException(String message) {
        super(message);
    }
}
