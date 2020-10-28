package com.demo.dataAudit.services;

import java.util.List;
import java.util.UUID;

import com.demo.dataAudit.dto.PatientQueryDTO;

public interface PatientQueryService {

	public PatientQueryDTO getPatient(UUID id);

	public List<PatientQueryDTO> listAllPatients();
}
