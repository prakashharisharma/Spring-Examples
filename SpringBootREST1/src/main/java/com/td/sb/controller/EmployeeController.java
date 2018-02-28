package com.td.sb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.td.sb.model.Employee;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	private final static List<Employee> listOfEmployees = new ArrayList<>();;
	
	static {
		createEmployeeList();
	}
	

	@GetMapping(value="/hi/")
	public String sayHello() {
		
		System.out.println("AAP2");
		
		return "Hello !";
	}
	
	@GetMapping(value="/employees/")
	public List<Employee> getEmployees() {
		
		System.out.println("AAP2");
		
		return listOfEmployees.stream().sorted((e1,e2) -> e1.getEmpId()-e2.getEmpId()).collect(Collectors.toList());
	}

	@PostMapping(value="/employees/")
	public ResponseEntity<?> createEmployee(@RequestBody Employee emp ) {
		System.out.println("EmployeeController.createEmployee()" + emp.getEmpId());
		
		emp.setEmpId(listOfEmployees.size()+1);
		
		listOfEmployees.add(emp);
		
		return ResponseEntity.ok("Employee created");
	}
	
	@GetMapping(value = "/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		List<Employee> listOfEmployees = createEmployeeList();
		
		return listOfEmployees.stream().filter((e) -> e.getEmpId() == id).findFirst().orElseGet(() -> {
            Employee e = new Employee("No Records Exist for id " + id);
           
            return e;
        });
	}

	public static List<Employee> createEmployeeList() {
		
		listOfEmployees.add(new Employee(1, "Prakash"));
		listOfEmployees.add(new Employee(2, "Rambir"));
		listOfEmployees.add(new Employee(3, "Sachin"));
		listOfEmployees.add(new Employee(4, "Martin"));
		
		return listOfEmployees;
	}
}
