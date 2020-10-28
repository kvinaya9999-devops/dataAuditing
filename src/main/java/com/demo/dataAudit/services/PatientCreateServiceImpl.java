package com.demo.dataAudit.services;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dataAudit.dto.PatientCreateDTO;
import com.demo.dataAudit.dto.PatientQueryDTO;
import com.demo.dataAudit.dto.PatientUpdateDTO;
import com.demo.dataAudit.entities.Patient;
import com.demo.dataAudit.entities.Status;
import com.demo.dataAudit.repositories.PatientRepository;



@Service
public class PatientCreateServiceImpl implements PatientCreateService {

	@Autowired
	private PatientRepository patientRepository;

	@Override
	public UUID createPatient(PatientCreateDTO patientCreateDTO) {

		Patient patient = new Patient();

		patient.setId(UUID.randomUUID());
		patient.setName(patientCreateDTO.getName());
		patient.setAge(patientCreateDTO.getAge());
		patient.setDoctor(patientCreateDTO.getDoctor());
		patient.setStatus(String.valueOf(Status.IN_PATIENT));
		return patientRepository.save(patient).getId();
	}

	@Override
	public PatientQueryDTO updatePatient(UUID id, PatientUpdateDTO patientUpdateDTO) {

		if (patientRepository.findById(id).isPresent()) {
			Patient existingPatient = patientRepository.findById(id).get();
			existingPatient.setDoctor(patientUpdateDTO.getDoctor());

			Patient updatedPatient = patientRepository.save(existingPatient);

			return new PatientQueryDTO(updatedPatient.getId(), updatedPatient.getName(), updatedPatient.getAge(),
					updatedPatient.getDoctor());

		}else {
			throw new EntityNotFoundException("Patient Id " + id.toString() + " not found in the database");
		}

	}


}
