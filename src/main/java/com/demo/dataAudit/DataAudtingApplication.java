package com.demo.dataAudit;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.demo.dataAudit.entities.Doctor;
import com.demo.dataAudit.entities.Patient;
import com.demo.dataAudit.repositories.DoctorRepositary;
import com.demo.dataAudit.repositories.PatientRepository;

@SpringBootApplication
public class DataAudtingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataAudtingApplication.class, args);
	}
	
	@Component
	class DemoCommandLineRunner implements CommandLineRunner {

		@Autowired
		private PatientRepository patientRepository;
		
		@Autowired
		private DoctorRepositary doctorRepository;

		@Override
		public void run(String... args) throws Exception {

			Patient p1 = new Patient();
			p1.setId(UUID.randomUUID());
			p1.setName("Vinaya");
			p1.setAge("35");
			p1.setDoctor("Dr Thomas");

			patientRepository.save(p1);

			Patient p2 = new Patient();
			p2.setId(UUID.randomUUID());
			p2.setName("Pete");
			p2.setAge("35");
			p2.setDoctor("Dr Asha");

			patientRepository.save(p2);

			Patient p3 = new Patient();
			p3.setId(UUID.randomUUID());
			p3.setName("Monika");
			p3.setAge("35");
			p3.setDoctor("Dr Nayan");

			patientRepository.save(p3);
			
			
			Doctor d1 = new Doctor();
			d1.setdId(UUID.randomUUID());
			d1.setDname("Mac");
			d1.setDept("General");
			
			doctorRepository.save(d1);

		}
	}


}
