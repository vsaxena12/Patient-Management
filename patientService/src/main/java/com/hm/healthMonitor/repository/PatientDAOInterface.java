package com.hm.healthMonitor.repository;

import com.hm.healthMonitor.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PatientDAOInterface extends JpaRepository<Patient, UUID> {
    //Jpa Already has the following CRUD functionality
    //void save(PatientEntity patientEntity);
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, UUID id);
}
