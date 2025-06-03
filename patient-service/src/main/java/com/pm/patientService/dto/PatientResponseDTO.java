package com.pm.patientService.dto;

import java.time.LocalDate;
import java.util.UUID;

public class PatientResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String address;
    private LocalDate dob;
    private LocalDate registered_Date;

    public PatientResponseDTO(UUID id, String name, String email, String address, LocalDate dob, LocalDate registered_Date) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.registered_Date = registered_Date;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getregistered_Date() {
        return registered_Date;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setregistered_Date(LocalDate registered_Date) {
        this.registered_Date = registered_Date;
    }

    @Override
    public String toString() {
        return "PatientResponseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", registered_Date=" + registered_Date +
                '}';
    }
}
