package com.demo.dataAudit.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.dataAudit.entities.Patient;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "patients", path = "patients")
public interface PatientRepository extends CrudRepository<Patient, UUID>{
	
	List<Patient> findByName(@Param("name") String name);
}
