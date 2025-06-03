package com.pm.patientService.mapper;

import com.pm.patientService.dto.PatientResponseDTO;
import com.pm.patientService.entity.Patient;

public class PatientMapper {
    public static PatientResponseDTO map(Patient patient) {

        return new PatientResponseDTO(patient.getId(), patient.getName(), patient.getEmail(), patient.getAddress(), patient.getDob(), patient.getregistered_Date());

    }
}
