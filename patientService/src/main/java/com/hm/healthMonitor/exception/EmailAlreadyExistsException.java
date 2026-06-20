package com.hm.healthMonitor.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String message) {
        //System.out.println(message);
        super(message);
    }
}
