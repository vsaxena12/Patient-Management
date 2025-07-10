package com.hm.healthMonitor.service;

import com.hm.healthMonitor.dao.PatientDAOInterface;
import com.hm.healthMonitor.dto.PatientRequestDTO;
import com.hm.healthMonitor.exception.EmailAlreadyExistsException;
import com.hm.healthMonitor.model.PatientEntity;
import com.hm.healthMonitor.dto.PatientResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    private PatientDAOInterface patientDAOInterface;

    public PatientService(PatientDAOInterface patientDAOInterface) {
        this.patientDAOInterface = patientDAOInterface;
    }

    public List<PatientResponseDTO> findAll() {
        List<PatientEntity> patientEntityList = patientDAOInterface.findAll();
        System.out.println("Patient Entity List: "+patientEntityList);

        List<PatientResponseDTO> patientResponseDTOList = patientEntityList.stream().map(patientEntity ->
                new PatientResponseDTO(
                        String.valueOf(patientEntity.getUuid()),
                        patientEntity.getFirstName(),
                        patientEntity.getLastName(),
                        patientEntity.getEmail(),
                        patientEntity.getAddress(),
                        patientEntity.getDateOfBirth()
                )).toList();

        System.out.println("Patient Response DTO: "+patientResponseDTOList);

        return patientResponseDTOList;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if(patientDAOInterface.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email already exists"+
                    patientRequestDTO.getEmail());
        }
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setFirstName(patientRequestDTO.getFirstName());
        patientEntity.setLastName(patientRequestDTO.getLastName());
        patientEntity.setEmail(patientRequestDTO.getEmail());
        patientEntity.setAddress(patientRequestDTO.getAddress());
        patientEntity.setDateOfBirth(patientRequestDTO.getDateOfBirth());
        patientEntity.setDateOfAdmit(patientRequestDTO.getDateOfAdmit());
        patientEntity.setDateOfDischarge(patientRequestDTO.getDateOfDischarge());

        patientDAOInterface.save(patientEntity);

        return new PatientResponseDTO(
                String.valueOf(patientEntity.getUuid()),
                patientEntity.getFirstName(),
                patientEntity.getLastName(),
                patientEntity.getEmail(),
                patientEntity.getAddress(),
                patientEntity.getDateOfBirth()
        );
    }

    public PatientResponseDTO updatePatient(UUID uuid, PatientRequestDTO patientRequestDTO) {

        PatientEntity patientEntity = patientDAOInterface.findById(uuid)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: "+uuid));

        //Fix validations here
        if(patientDAOInterface.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email already exists"+
                    patientRequestDTO.getEmail());
        }

        patientEntity.setFirstName(patientRequestDTO.getFirstName());
        patientEntity.setLastName(patientRequestDTO.getLastName());
        patientEntity.setEmail(patientRequestDTO.getEmail());
        patientEntity.setDateOfBirth(patientRequestDTO.getDateOfBirth());

        patientDAOInterface.save(patientEntity);

        return new PatientResponseDTO(
                String.valueOf(patientEntity.getUuid()),
                patientEntity.getFirstName(),
                patientEntity.getLastName(),
                patientEntity.getEmail(),
                patientEntity.getAddress(),
                patientEntity.getDateOfBirth()
        );
    }

}
