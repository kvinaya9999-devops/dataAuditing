package com.demo.dataAudit.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.UUID;

@ApiModel(description = "Model to read Patient information")
public class PatientQueryDTO {
	
	@ApiModelProperty(notes = "Unique Id of the patient")
    private UUID id;

    @ApiModelProperty(notes = "name", example = "vinaya")
    private String name;

    @ApiModelProperty(notes = "age", example = "23")
    private String age;

    @ApiModelProperty(notes = "doctor", example = "doctor")
    private String doctor;

    public PatientQueryDTO(UUID id, String name, String age, String doctor) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.doctor = doctor;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        return "PateintQueryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", doctor='" + doctor + '\'' +
                '}';
    }
}
