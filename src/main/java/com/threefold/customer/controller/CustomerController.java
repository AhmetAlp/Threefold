package com.threefold.customer.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threefold.customer.exception.ResourceNotFoundException;
import com.threefold.customer.model.Customer;
import com.threefold.customer.service.CustomerService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/customers/{page}/{size}")
	public Page<Customer> getCustomers(@PathVariable(value = "page") int page, @PathVariable(value = "size") int size) {
		return customerService.getCustomers(page, size);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomer(@PathVariable(value = "id") String id) throws ResourceNotFoundException {
		return customerService.getCustomer(id);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/create")
	public Customer createVehicle(@Valid @RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteVehicle(@PathVariable(value = "id") String id)
			throws ResourceNotFoundException {
		return customerService.deleteCustomer(id);
	}
		
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateVehicle(@PathVariable(value = "id") String id,
			@Valid @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		final Customer updatedVehicle = customerService.updateCustomer(id, customerDetails);
		return ResponseEntity.ok(updatedVehicle);
	}
	
}
