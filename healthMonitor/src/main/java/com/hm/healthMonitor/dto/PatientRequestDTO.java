package com.hm.healthMonitor.dto;

import com.hm.healthMonitor.customValidation.ValidAdmissionDates;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

@ValidAdmissionDates
public class PatientRequestDTO {
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email Should be valid")
    private String email;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @Past(message = "Date of birth must be in the past")
    @NotNull(message = "Date of birth cannot be null")
    private LocalDate dateOfBirth;

    @NotNull(message = "Date of admit cannot be null")
    private LocalDate dateOfAdmit;

    private LocalDate dateOfDischarge;

    public PatientRequestDTO() {}

    public PatientRequestDTO(String firstName, String lastName, String email, String address, LocalDate dateOfBirth, LocalDate dateOfAdmit, LocalDate dateOfDischarge) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAdmit = dateOfAdmit;
        this.dateOfDischarge = dateOfDischarge;
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
        return "PatientRequestDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfAdmit=" + dateOfAdmit +
                ", dateOfDischarge=" + dateOfDischarge +
                '}';
    }
}
