package com.hm.healthMonitor.service;

import com.hm.healthMonitor.dto.PatientRequestDTO;
import com.hm.healthMonitor.dto.PatientResponseDTO;
import com.hm.healthMonitor.exception.EmailAlreadyExistsException;
import com.hm.healthMonitor.exception.PatientNotFoundException;
import com.hm.healthMonitor.exception.UUIDNotFoundException;
import com.hm.healthMonitor.grpc.BillingServiceGrpcClient;
import com.hm.healthMonitor.kafka.KafkaProducer;
import com.hm.healthMonitor.model.Patient;
import com.hm.healthMonitor.repository.PatientDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class PatientService {

    private final PatientDAOInterface patientDAOInterface;
    private final BillingServiceGrpcClient billingServiceGrpcClient;
    private final KafkaProducer kafkaProducer;

    public PatientService(PatientDAOInterface patientDAOInterface,
                          BillingServiceGrpcClient billingServiceGrpcClient,
                          KafkaProducer kafkaProducer) {
        this.patientDAOInterface = patientDAOInterface;
        this.billingServiceGrpcClient = billingServiceGrpcClient;
        this.kafkaProducer = kafkaProducer;
    }

    public List<PatientResponseDTO> getAllPatients() {
        List<Patient> patientList = patientDAOInterface.findAll();
        System.out.println("Patient Entity List: "+patientList);

        List<PatientResponseDTO> patientResponseDTOList = new ArrayList<>();

        for(Patient patient: patientList) {
            PatientResponseDTO patientResponseDTO = new PatientResponseDTO(String.valueOf(patient.getUUID()),
                    patient.getFirstName(),
                    patient.getLastName(),
                    patient.getEmail(),
                    patient.getAddress(),
                    patient.getDateOfBirth(),
                    patient.getDateOfAdmit(),
                    patient.getDateOfDischarge());
            if(Objects.equals(patientResponseDTO.getId(), "123e4567-e89b-12d3-a456-426614174000")) {
                patientResponseDTO.setFirstName("Varun");
                patientResponseDTO.setLastName("Saxena");
            }
            patientResponseDTOList.add(patientResponseDTO);
        }

        // Using Streams
        //        List<PatientResponseDTO> patientResponseDTOList = patientList.stream().map(patient ->
        //                new PatientResponseDTO(
        //                        String.valueOf(patient.getUUID()),
        //                        patient.getFirstName(),
        //                        patient.getLastName(),
        //                        patient.getEmail(),
        //                        patient.getAddress(),
        //                        patient.getDateOfBirth(),
        //                        patient.getDateOfAdmit(),
        //                        patient.getDateOfDischarge()
        //                )).toList();
        System.out.println("Patient Response DTO: "+patientResponseDTOList);
        return patientResponseDTOList;
    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        if(patientDAOInterface.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email already exists"+
                    patientRequestDTO.getEmail());
        }
        Patient patient = new Patient();
        patient.setFirstName(patientRequestDTO.getFirstName());
        patient.setLastName(patientRequestDTO.getLastName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(patientRequestDTO.getDateOfBirth());
        patient.setDateOfAdmit(patientRequestDTO.getDateOfAdmit());
        patient.setDateOfDischarge(patientRequestDTO.getDateOfDischarge());

        Patient newPatient = null;
        try {
            newPatient = patientDAOInterface.save(patient);
        } catch(Exception e) {
            System.out.println("Same patient already exists");
        }

        try {
            billingServiceGrpcClient.createBillingAccount(patient.getUUID().toString(), patient.getFirstName(),
            patient.getEmail());
        } catch(Exception e) {
            System.out.println("GRPC Billing is down!");
        }

        kafkaProducer.sendEvent(newPatient);

        return new PatientResponseDTO(
                String.valueOf(patient.getUUID()),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDateOfBirth(),
                patient.getDateOfAdmit(),
                patient.getDateOfDischarge()
        );
    }

    public PatientResponseDTO updatePatient(UUID uuid, PatientRequestDTO patientRequestDTO) {
        Patient patient = patientDAOInterface.findById(uuid)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with ID: "+uuid));

        if(patientDAOInterface.existsByEmailAndIdNot(patient.getEmail(), uuid)) {
            throw new EmailAlreadyExistsException("A patient with this email already exists"+
                    patientRequestDTO.getEmail());
        }

        patient.setFirstName(patientRequestDTO.getFirstName());
        patient.setLastName(patientRequestDTO.getLastName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setDateOfBirth(patientRequestDTO.getDateOfBirth());
        patient.setDateOfAdmit(patientRequestDTO.getDateOfAdmit());
        patient.setDateOfDischarge(patientRequestDTO.getDateOfDischarge());

        patientDAOInterface.save(patient);

        return new PatientResponseDTO(
                String.valueOf(patient.getUUID()),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDateOfBirth(),
                patient.getDateOfAdmit(),
                patient.getDateOfDischarge()
        );
    }

    public void deletePatient(UUID uuid) {
        if(patientDAOInterface.existsById(uuid)) {
            patientDAOInterface.deleteById(uuid);
        } else {
            throw new UUIDNotFoundException("UUID Doesn't exists in the DB");
        }
    }
}
