package com.hm.healthMonitor.customValidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateRangeValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAdmissionDates {
    String message() default "Discharge date must be after admit date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}