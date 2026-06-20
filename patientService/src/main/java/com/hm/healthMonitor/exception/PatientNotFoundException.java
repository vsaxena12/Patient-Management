package com.hm.healthMonitor.exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        //System.out.println(message);
        super(message);
    }
}
