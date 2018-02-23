package com.td.sb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.td.sb.model.Employee;

@Controller
public class EmployeeController {

	private final static List<Employee> listOfEmployees = new ArrayList<>();;
	
	static {
		listOfEmployees.add(new Employee(1, "Prakash"));
		listOfEmployees.add(new Employee(2, "Rambir"));
		listOfEmployees.add(new Employee(3, "Sachin"));
		listOfEmployees.add(new Employee(4, "Martin"));
	}
	
	@GetMapping(value = "/employees", produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Employee> getEmployee() {
		
		return listOfEmployees;
	}
	
	@GetMapping("/employees")
	public String getEmployeeJSP(Model model) {
		
		model.addAttribute("empList",listOfEmployees);
		
		return "employee";
	}
	
}
