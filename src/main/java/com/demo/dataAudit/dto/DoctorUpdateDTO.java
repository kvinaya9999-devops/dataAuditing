package com.demo.dataAudit.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model to update an existing doctor")
public class DoctorUpdateDTO {

	@NotNull
	@ApiModelProperty(notes = "dept", example = "dept name")
	private String dept;

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "DoctorUpdateDTO{" + ", dept='" + dept + '\'' + '}';
	}

}
