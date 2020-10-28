package com.demo.dataAudit.services;

import java.util.UUID;

import com.demo.dataAudit.dto.PatientCreateDTO;
import com.demo.dataAudit.dto.PatientQueryDTO;
import com.demo.dataAudit.dto.PatientUpdateDTO;



public interface PatientCreateService {

	public UUID createPatient(PatientCreateDTO patientCreateDTO);

	public PatientQueryDTO updatePatient(UUID id, PatientUpdateDTO patientUpdateDTO);
}
