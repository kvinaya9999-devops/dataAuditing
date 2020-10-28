package com.demo.dataAudit.services;

import java.util.UUID;

import com.demo.dataAudit.dto.DoctorCreateDTO;
import com.demo.dataAudit.dto.DoctorQueryDTO;
import com.demo.dataAudit.dto.DoctorUpdateDTO;

public interface DoctorCreateService {
	
	public UUID createDoctor(DoctorCreateDTO doctorCreateDTO);

	public DoctorQueryDTO updateDoctor(UUID id, DoctorUpdateDTO doctorUpdateDTO);

}
