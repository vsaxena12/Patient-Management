package com.pm.patientService.controller;

import com.pm.patientService.dto.PatientResponseDTO;
import com.pm.patientService.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {
        List<PatientResponseDTO> patients = patientService.getAllPatients();
        return ResponseEntity.status(200).body(patients);
    }

    @PostMapping("/create")
    public ResponseEntity<PatientResponseDTO> createPatient(@RequestBody PatientResponseDTO patientResponseDTO) {
        return ResponseEntity.status(200).body(patientService.createPatient(patientResponseDTO));
    }
}
