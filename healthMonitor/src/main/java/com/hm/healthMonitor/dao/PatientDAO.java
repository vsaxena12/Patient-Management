package com.hm.healthMonitor.dao;

import com.hm.healthMonitor.model.PatientEntity;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public class PatientDAO implements PatientDAOInterface{

    private final EntityManager entityManager;

    @Autowired
    public PatientDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(PatientEntity patientEntity) {
        entityManager.persist(patientEntity);
    }


}
