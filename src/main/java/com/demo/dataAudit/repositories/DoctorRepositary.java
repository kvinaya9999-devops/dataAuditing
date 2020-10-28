package com.demo.dataAudit.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.dataAudit.entities.Doctor;

@RepositoryRestResource(collectionResourceRel = "doctor", path = "doctor")
public interface DoctorRepositary extends CrudRepository<Doctor, UUID>{

	@Override
    <S extends Doctor> S save(S s);
}
