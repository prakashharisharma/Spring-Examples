package com.td.sb.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.td.sb.model.Student;

@RestController
public class StudentController {

	private static final String TEMPLATE = "Hello, %s!";

    @RequestMapping("/students")
    public HttpEntity<Student> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "Student") String name) {

        Student student = new Student(String.format(TEMPLATE, name));
        student.add(
        		linkTo(methodOn(StudentController.class).greeting(name)).withSelfRel()
        		);
        student.add(
        		linkTo(methodOn(StudentController.class).getStudent(1)).withRel("getstudent")
        		);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
    
    @RequestMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
    	
		return new Student("");
    	
    }
    
}
