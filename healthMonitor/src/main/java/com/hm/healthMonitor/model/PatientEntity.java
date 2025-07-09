package com.hm.healthMonitor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID uuid;

    @Column(name = "first_name")
    @NotNull
    private String firstName;

    @Column
    @NotNull
    private String lastName;

    @Column(unique = true)
    @Email
    @NotNull
    private String email;

    @Column
    @NotNull
    private String address;

    @Column
    @NotNull
    @DateTimeFormat
    private LocalDate dateOfBirth;

    @Column
    @NotNull
    @DateTimeFormat
    private LocalDate dateOfAdmit;

    @Column
    @DateTimeFormat
    private LocalDate dateOfDischarge;


    public PatientEntity() {

    }

    public PatientEntity(String firstName, String lastName, String email, String address, LocalDate dateOfBirth, LocalDate dateOfAdmit, LocalDate dateOfDischarge) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAdmit = dateOfAdmit;
        this.dateOfDischarge = dateOfDischarge;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfAdmit() {
        return dateOfAdmit;
    }

    public void setDateOfAdmit(LocalDate dateOfAdmit) {
        this.dateOfAdmit = dateOfAdmit;
    }

    public LocalDate getDateOfDischarge() {
        return dateOfDischarge;
    }

    public void setDateOfDischarge(LocalDate dateOfDischarge) {
        this.dateOfDischarge = dateOfDischarge;
    }
}
