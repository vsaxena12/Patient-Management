package com.hm.healthMonitor.controller;

import com.hm.healthMonitor.service.PatientService;
import com.hm.healthMonitor.service.dto.PatientResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PatientController {


    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponseDTO>> findAll() {
        List<PatientResponseDTO> patientResponseDTOList = patientService.findAll();
        return ResponseEntity.ok().body(patientResponseDTOList);

    }
}
