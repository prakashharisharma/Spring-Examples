package com.td.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.td.sb.model.Employee;
import com.td.sb.repo.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private Environment environment;

	@Autowired
	private EmployeeRepository repository;
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee( @PathVariable Long id) {
	
		System.out.println(id);
		Employee emp = repository.findByEmpId(id);
		
		return emp;
	}
	
	@GetMapping("/hi")
	public String sayHello() {
		return "hi";
	}
	
}
