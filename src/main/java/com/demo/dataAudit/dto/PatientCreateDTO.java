package com.demo.dataAudit.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model to create a new Patient")
public class PatientCreateDTO {

	@NotNull
	@ApiModelProperty(notes = "name", example = "Vinaya")
	private String name;

	@NotNull
	@ApiModelProperty(notes = "Age", example = "years old")
	private String age;

	@NotNull
	@ApiModelProperty(notes = "Doctor", example = "Dr..")
	private String doctor;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "PatientCreateDTO{" + "Name='" + name + '\'' + ", Age='" + age + '\'' + ", Doctor='" + doctor + '\''
				+ '}';
	}
}
