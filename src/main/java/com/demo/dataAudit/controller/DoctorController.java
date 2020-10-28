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

import com.demo.dataAudit.dto.DoctorCreateDTO;
import com.demo.dataAudit.dto.DoctorQueryDTO;
import com.demo.dataAudit.dto.DoctorUpdateDTO;
import com.demo.dataAudit.services.DoctorCreateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/doctor")
@Api(tags = "Doctor --", value = "doctorqueries", description = "Controller for doctor service")
public class DoctorController {
	
	@Autowired
	private DoctorCreateService doctorCreateService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Create a new doctor record")
	public ResponseEntity<UUID> createPatient(@Valid @RequestBody DoctorCreateDTO doctorCreateDTO) {
		return new ResponseEntity<>(doctorCreateService.createDoctor(doctorCreateDTO), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Update an existing doctor")
	public ResponseEntity<DoctorQueryDTO> updatePatient(@PathVariable(value = "id") UUID id,
			@RequestBody DoctorUpdateDTO doctorUpdateDTO) {
		System.out.print("id --->"+id);
		return new ResponseEntity<>(doctorCreateService.updateDoctor(id, doctorUpdateDTO), HttpStatus.OK);
	}

}
