package com.demo.dataAudit.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "patient")
@Audited
public class Patient {

	@Id
	private UUID id;

	private String name;

	private String age;

	private String doctor;

	private String status;

	public Patient() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Patient{" + "id=" + id + ", Name='" + name + '\'' + ", Age='" + age + '\'' + ", Doctor='" + doctor
				+ '\'' + ", status='" + status + '\'' + '}';
	}
}
