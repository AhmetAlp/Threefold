package com.threefold.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.threefold.customer.controller.CustomerController;
import com.threefold.customer.exception.ResourceNotFoundException;
import com.threefold.customer.model.Customer;
import com.threefold.customer.service.CustomerService;


@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	@InjectMocks
	private CustomerController cont;
	
	@Mock
	private CustomerService customerService;
	
	@MockBean
	private CustomHttpInterceptor customHttpInterceptor;
	
	Customer customer = new Customer();
	
	@Before
	public void setUp() {
		customer.setIdNumber("1");
		customer.setEmail("test@test.com");
		customer.setInitials("Ms");
		customer.setLastupdated(1);
		customer.setMobile("555555");
		customer.setName("Julianne");
		customer.setSurname("Doe");		
	}
	
	@Test
	public void getCustomers() throws Exception {
		//Given
		String expectedMail = "test@test.com";
		List<Customer> contents = new ArrayList<>();
		contents.add(customer);
		Page<Customer> retPage = new PageImpl<Customer>(contents);
		Mockito.when(customerService.getCustomers(0, 10)).thenReturn(retPage);
		
		//when
		Page<Customer> res = cont.getCustomers(0, 10);
		
		//check
		assertEquals(1, res.getContent().size());
		assertEquals(expectedMail, res.getContent().get(0).getEmail());				
	}
	
	@Test
	public void getCustomerWithId() {
		//Given
		String expectedMail = "test@test.com";
		try {
			Mockito.when(customerService.getCustomer("1")).thenReturn(customer);
		} catch (ResourceNotFoundException e) {
			
		}
		
		//when
		Customer retCustomer = null;
		try {
			retCustomer = cont.getCustomer("1");
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//check
		assertNotNull(retCustomer);
		assertEquals("1", retCustomer.getIdNumber());				
		assertEquals(expectedMail, retCustomer.getEmail());						
	}
	
	@Test
	public void createCustomer() {
		//Given

		//when
		Customer retCustomer = null;
		retCustomer = cont.createCustomer(customer);
		
		//check
		Mockito.verify(customerService, Mockito.times(1)).createCustomer(Mockito.any(Customer.class));		
	}

	@Test
	public void deleteCustomer() throws ResourceNotFoundException {
		//Given

		//when
		try {
			cont.deleteCustomer("1");
		} catch (ResourceNotFoundException e) {
			
		}
		
		//check
		Mockito.verify(customerService, Mockito.times(1)).deleteCustomer("1");		
	}	

	@Test
	public void updateCustomer() throws ResourceNotFoundException {
		//Given

		//when
		try {
			cont.updateCustomer("1", customer);
		} catch (ResourceNotFoundException e) {
			
		}
		
		//check
		Mockito.verify(customerService, Mockito.times(1)).updateCustomer(Mockito.anyString(), Mockito.any(Customer.class));		
	}	

}
