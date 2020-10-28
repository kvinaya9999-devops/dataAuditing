package com.demo.dataAudit.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dataAudit.dto.PatientCreateDTO;
import com.demo.dataAudit.dto.PatientQueryDTO;
import com.demo.dataAudit.dto.PatientUpdateDTO;
import com.demo.dataAudit.services.PatientCreateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/patient")
@Api(tags = "Patient --", value = "patientqueries", description = "Controller for patient service")
public class PatientController {

	@Autowired
	private PatientCreateService patientCreateService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create a new patient record")
	public ResponseEntity<UUID> createPatient(@Valid @RequestBody PatientCreateDTO patientCreateDTO) {
		return new ResponseEntity<>(patientCreateService.createPatient(patientCreateDTO), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Update an existing patient")
	public ResponseEntity<PatientQueryDTO> updatePatient(@PathVariable(value = "id") UUID id,
			@RequestBody PatientUpdateDTO patientUpdateDTO) {
		return new ResponseEntity<>(patientCreateService.updatePatient(id, patientUpdateDTO), HttpStatus.OK);
	}

}
