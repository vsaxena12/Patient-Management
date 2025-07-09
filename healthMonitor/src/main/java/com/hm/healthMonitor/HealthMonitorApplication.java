package com.hm.healthMonitor;

import com.hm.healthMonitor.dao.PatientDAO;
import com.hm.healthMonitor.model.PatientEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class HealthMonitorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HealthMonitorApplication.class, args);

		// Get the bean from context
		HealthMonitorApplication app = context.getBean(HealthMonitorApplication.class);
		//app.createPatient(patientEntity);
	}

	@Bean
	public CommandLineRunner init(PatientDAO patientDAO) {
		return args -> {
			createPatient(patientDAO); // or any other startup logic
		};
	}

	public void createPatient(PatientDAO patientDAO) {
		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setUuid(UUID.randomUUID());
		patientEntity.setFirstName("Brittany");
		patientEntity.setLastName("Blackburn");
		patientEntity.setEmail("brittany.blackburn@gmail.com");
		patientEntity.setAddress("ABC");
		patientEntity.setDateOfBirth(LocalDate.parse("1992-08-05"));
		patientEntity.setDateOfAdmit(LocalDate.now());
		patientEntity.setDateOfDischarge(null);

		patientDAO.save(patientEntity);

		System.out.println("Patient saved!");
	}
}