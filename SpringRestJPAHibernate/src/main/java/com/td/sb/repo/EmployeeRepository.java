package com.td.sb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.td.sb.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByName(String name);
	Employee findByEmpId(Long id);
}
