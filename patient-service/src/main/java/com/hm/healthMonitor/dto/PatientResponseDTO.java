package com.hm.healthMonitor.dto;

import java.time.LocalDate;

public class PatientResponseDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private LocalDate dateOfBirth;
    private LocalDate dateOfAdmit;
    private LocalDate dateOfDischarge;

    public PatientResponseDTO() {}

    public PatientResponseDTO(String id, String firstName, String lastName, String email,
                              String address, LocalDate dateOfBirth, LocalDate dateOfAdmit,
                              LocalDate dateOfDischarge) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAdmit = dateOfAdmit;
        this.dateOfDischarge = dateOfDischarge;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "PatientResponseDTO{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfAdmit=" + dateOfAdmit +
                ", dateOfDischarge=" + dateOfDischarge +
                '}';
    }
}
