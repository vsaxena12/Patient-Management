package com.pm.patientService.service;

import com.pm.patientService.dto.PatientResponseDTO;
import com.pm.patientService.entity.Patient;
import com.pm.patientService.mapper.PatientMapper;
import com.pm.patientService.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private PatientRepo patientRepo;

    @Autowired
    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patients = patientRepo.findAll();
        return patients.stream().map(PatientMapper::map).toList();
    }

    public PatientResponseDTO createPatient(PatientResponseDTO patientResponseDTO) {
        Patient patient = new Patient();
        patient.setId(UUID.randomUUID());
        patient.setName(patientResponseDTO.getName());
        patient.setEmail(patientResponseDTO.getEmail());
        patient.setAddress(patientResponseDTO.getAddress());
        patient.setDob(patientResponseDTO.getDob());
        patient.setregistered_Date(patientResponseDTO.getregistered_Date());
        patientRepo.save(patient);
        return PatientMapper.map(patient);
    }




}
