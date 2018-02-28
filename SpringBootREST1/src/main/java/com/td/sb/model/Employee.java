package com.td.sb.model;

public class Employee {
	private String name;
	private int empId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public Employee(int empId, String name) {
		this.name = name;
		this.empId = empId;
	}
	
	public Employee(String name) {
		this.name = name;
	}
	public Employee() {
		
	}
}
