package com.demo.dataAudit.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model to update an existing patient")
public class PatientUpdateDTO {

	@NotNull
	@ApiModelProperty(notes = "Doctor", example = "Dr..")
	private String doctor;

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "PatientUpdateDTO{" + ", doctor='" + doctor + '\'' + '}';
	}
}
