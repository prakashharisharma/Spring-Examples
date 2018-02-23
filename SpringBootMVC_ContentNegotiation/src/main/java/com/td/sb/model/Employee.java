package com.td.sb.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.NONE)
public class Employee {
	private static final long serialVersionUID = 5088863992478607917L;

	@XmlAttribute
	private Integer id;

	@XmlElement
	private String firstName;


	public Employee(Integer id, String firstName) {
		super();
		this.id = id;
		this.firstName = firstName;
	}

	public Employee() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + "]";
	}
}
