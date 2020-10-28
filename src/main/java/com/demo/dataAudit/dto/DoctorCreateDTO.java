package com.demo.dataAudit.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model to create a new doctor")
public class DoctorCreateDTO {

	
	@NotNull
	@ApiModelProperty(notes = "dname", example = "rony")
	private String dname;

	@NotNull
	@ApiModelProperty(notes = "dept", example = "department")
	private String dept;
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
}
