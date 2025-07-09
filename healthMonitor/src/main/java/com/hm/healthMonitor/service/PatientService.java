package com.hm.healthMonitor.service;

import com.hm.healthMonitor.dao.PatientDAOInterface;
import com.hm.healthMonitor.model.PatientEntity;
import com.hm.healthMonitor.service.dto.PatientResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
