package com.hm.healthMonitor.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<?> handleEmailAlreayException(EmailAlreadyExistsException ex) {
        logger.warn("Email address already exists {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Email address already exists");
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<?> handlePatientNotFoundException(PatientNotFoundException ex) {
        logger.warn("Patient Not Found {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Patient doesn't exists");
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(UUIDNotFoundException.class)
    public ResponseEntity<?> handleUUIDNotFoundException(UUIDNotFoundException ex) {
        logger.warn("UUID Not Found {}", ex.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "UUID doesn't exists");
        return ResponseEntity.badRequest().body(errors);
    }
}
