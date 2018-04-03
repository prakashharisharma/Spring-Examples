package com.td.sb.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.td.sb.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String>  {

	public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
    
}
