package com.td.sb.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.td.sb.model.Employee;

@Component	
@Path("/api")
public class EmployeeResource {

	private final static List<Employee> listOfEmployees = new ArrayList<>();;

	static {

		listOfEmployees.add(new Employee(1, "Prakash"));
		listOfEmployees.add(new Employee(2, "Rambir"));
		listOfEmployees.add(new Employee(3, "Sachin"));
		listOfEmployees.add(new Employee(4, "Martin"));

	}

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Path("/helloworld")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloMessage() {
		return "Hello World Jersey Way!";
	}

	@GET
	@Path("/employees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployees() {
		
		return listOfEmployees.stream().sorted((e1,e2) -> e1.getEmpId()-e2.getEmpId()).collect(Collectors.toList());
	}
	
	@GET
	@Path("/employees/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeById(@PathParam("id") int id) {
		
		Optional<Employee> emp =  listOfEmployees.stream().filter((e) -> e.getEmpId() == id).findAny();
		
		if(emp.isPresent()) {
			return Response.status(200).entity(emp.get()).build();
		}
		
		return Response.status(404).entity("No record found!").build();
	}

	
	@POST
	@Path("/employees")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createEmployee(Employee emp ) throws URISyntaxException {
		
		emp.setEmpId(listOfEmployees.size()+1);
		
		listOfEmployees.add(emp);
		
		return Response.status(201).contentLocation(new URI("/api/employees/"+emp.getEmpId())).build();
	}
}
