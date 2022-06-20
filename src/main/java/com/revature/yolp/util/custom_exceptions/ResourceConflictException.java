package com.revature.yolp.util.custom_exceptions;

public class ResourceConflictException extends RuntimeException {
    public ResourceConflictException() {
        super();
    }

    public ResourceConflictException(String message) {
        super(message);
    }
}
