package com.td.sb.model;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student extends ResourceSupport{

	private final String name;
	
	//@JsonCreator - signal on how Jackson can create an instance of this POJO
	//@JsonProperty - clearly marks what field Jackson should put this constructor argument into
	 
	@JsonCreator
	    public Student(@JsonProperty("name") String name) {
	        this.name = name;
	    }

	    public String getName() {
	        return name;
	    }
}
