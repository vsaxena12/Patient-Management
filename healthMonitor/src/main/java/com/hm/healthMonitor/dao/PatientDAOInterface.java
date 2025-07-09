package com.hm.healthMonitor.dao;

import com.hm.healthMonitor.model.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientDAOInterface extends JpaRepository<PatientEntity, UUID> {
    //Jpa Already has the following CRUD functionality
    //void save(PatientEntity patientEntity);
}
