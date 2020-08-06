package com.threefold.customer.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.threefold.customer.exception.ResourceNotFoundException;
import com.threefold.customer.model.Customer;
import com.threefold.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	private static final String RESOURCE_EX_PREFIX = "Customer not found for this id :: ";
	
	@Autowired
	private CustomerRepository customerRepository;

	public Page<Customer> getCustomers(int page, int size) {
		return customerRepository.findAll(PageRequest.of(page, size));
	}
	
	public Customer getCustomer(String id) throws ResourceNotFoundException {
		return customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(RESOURCE_EX_PREFIX + id));
	}
	
	public Customer createCustomer(Customer customer) {
		long lastUpdate = new Date().getTime();
		customer.setLastupdated(lastUpdate);
		return customerRepository.save(customer);
	}
	
	public Map<String, Boolean> deleteCustomer(String id) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(RESOURCE_EX_PREFIX + id));
		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;		
	}
	
	public Customer updateCustomer(String id, Customer customerDetails) throws ResourceNotFoundException {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(RESOURCE_EX_PREFIX + id));

		long lastUpdate = new Date().getTime();
		customer.setName(customerDetails.getName());
		customer.setSurname(customerDetails.getSurname());
		customer.setEmail(customerDetails.getEmail());
		customer.setInitials(customerDetails.getInitials());
		customer.setMobile(customerDetails.getMobile());
		customer.setLastupdated(lastUpdate);
		return customerRepository.save(customer);		
	}
}
