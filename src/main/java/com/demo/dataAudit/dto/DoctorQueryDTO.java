package com.demo.dataAudit.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model to read doctor information")
public class DoctorQueryDTO {

	@NotNull
	@ApiModelProperty(notes = "did", example = "12323")
	private UUID dId;

	@NotNull
	@ApiModelProperty(notes = "dname", example = "rony")
	private String dname;

	@NotNull
	@ApiModelProperty(notes = "dept", example = "department")
	private String dept;

	public DoctorQueryDTO(UUID id, String dname, String dept) {
		this.dId = id;
		this.dname = dname;
		this.dept = dept;

	}

	public UUID getdId() {
		return dId;
	}

	public String getDname() {
		return dname;
	}

	public String getDept() {
		return dept;
	}

}
