package com.pm.patientService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PatientRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Size(min = 2, max = 100, message = "Email must be between 2 and 100 characters")
    private String email;

    @NotBlank(message = "Address is required")
    @Size(min = 2, max = 100, message = "Address must be between 2 and 100 characters")
    private String address;

    @NotBlank(message = "Dob is required")
    private LocalDate dob;

    @NotBlank(message = "Registered Date is required")
    private LocalDate registered_Date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getRegistered_Date() {
        return registered_Date;
    }

    public void setRegistered_Date(LocalDate registered_Date) {
        this.registered_Date = registered_Date;
    }

    public String toString() {
        return "PatientRequestDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", registered_Date=" + registered_Date +
                '}';
    }
}
