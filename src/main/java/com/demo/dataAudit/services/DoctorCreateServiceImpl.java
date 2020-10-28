package com.demo.dataAudit.services;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.javers.core.Javers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dataAudit.dto.DoctorCreateDTO;
import com.demo.dataAudit.dto.DoctorQueryDTO;
import com.demo.dataAudit.dto.DoctorUpdateDTO;
import com.demo.dataAudit.entities.Doctor;
import com.demo.dataAudit.repositories.DoctorRepositary;




@Service
public class DoctorCreateServiceImpl implements DoctorCreateService {

	@Autowired
	private DoctorRepositary doctorRepositary;
	
	@Autowired
	private final Javers javers;

	public DoctorCreateServiceImpl(Javers javers) {

		this.javers = javers;
	}

	public <T> void commit(String author, Doctor doctor) {

		javers.commit(author, doctor);
	}

	@Override
	public UUID createDoctor(DoctorCreateDTO doctorCreateDTO) {
		Doctor doctor = new Doctor();
		doctor.setdId(UUID.randomUUID());
		doctor.setDname(doctorCreateDTO.getDname());
		doctor.setDept(doctorCreateDTO.getDept());
		commit("Vinaya",doctor);
		return doctorRepositary.save(doctor).getdId();

	}
	
	

	@Override
	public DoctorQueryDTO updateDoctor(UUID id, DoctorUpdateDTO doctorUpdateDTO) {

		if (doctorRepositary.findById(id).isPresent()) {
			Doctor existingdoctor = doctorRepositary.findById(id).get();
			existingdoctor.setDept(doctorUpdateDTO.getDept());
			commit("Vinaya",existingdoctor);
			Doctor update = doctorRepositary.save(existingdoctor);

			return new DoctorQueryDTO(update.getdId(), update.getDname(), update.getDept());
		} else {
			throw new EntityNotFoundException("Patient Id " + id.toString() + " not found in the database");
		}
	}

}
