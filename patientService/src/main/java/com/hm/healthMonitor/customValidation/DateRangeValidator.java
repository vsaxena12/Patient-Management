package com.hm.healthMonitor.customValidation;

import com.hm.healthMonitor.dto.PatientRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidAdmissionDates, PatientRequestDTO> {

    @Override
    public boolean isValid(PatientRequestDTO dto, ConstraintValidatorContext context) {
        if (dto.getDateOfAdmit() == null || dto.getDateOfDischarge() == null) {
            return true;
        }

        if (!dto.getDateOfDischarge().isAfter(dto.getDateOfBirth()) ||
                !dto.getDateOfAdmit().isAfter(dto.getDateOfBirth())) {
            // Disable default message
            context.disableDefaultConstraintViolation();
            // Add custom message to global error
            context.buildConstraintViolationWithTemplate("Cannot admit or discharge patient if not born!")
                    .addPropertyNode("dateOfAdmit/dateOfDischarge") // attach to specific field if needed
                    .addConstraintViolation();
            return false;
        }

        if (!dto.getDateOfDischarge().isAfter(dto.getDateOfAdmit())) {
            // Disable default message
            context.disableDefaultConstraintViolation();
            // Add custom message to global error
            context.buildConstraintViolationWithTemplate("Discharge date must be after admit date")
                    .addPropertyNode("dateOfDischarge") // attach to specific field if needed
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
