package com.hm.healthMonitor.controller;

import com.hm.healthMonitor.dto.PatientRequestDTO;
import com.hm.healthMonitor.service.PatientService;
import com.hm.healthMonitor.dto.PatientResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
public class PatientController {


    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<PatientResponseDTO>> findAll() {
        List<PatientResponseDTO> patientResponseDTOList = patientService.findAll();
        return ResponseEntity.ok().body(patientResponseDTOList);

    }

    @PostMapping("/createPatient")
    public ResponseEntity<PatientResponseDTO> createPatient(@Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.createPatient(patientRequestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);

    }

    @PutMapping("/updatePatient/{uuid}")
    public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID  uuid, @Valid @RequestBody PatientRequestDTO patientRequestDTO) {
        PatientResponseDTO patientResponseDTO = patientService.updatePatient(uuid, patientRequestDTO);
        return ResponseEntity.ok().body(patientResponseDTO);

    }

    @DeleteMapping("/deletePatient/{uuid}")
    public ResponseEntity<Void> deletePatient(@PathVariable UUID  uuid) {
        patientService.deletePatient(uuid);
        return ResponseEntity.noContent().build();

    }
}
