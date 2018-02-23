package com.td.sb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@Column(name = "emp_id")
	private Long empId;

	@Column(name = "emp_name")
	private String name;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Employee(Long empId, String name) {
		this.name = name;
		this.empId = empId;
	}

	public Employee(String name) {
		this.name = name;
	}

	public Employee() {

	}
}
