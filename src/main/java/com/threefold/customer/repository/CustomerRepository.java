package com.threefold.customer.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.threefold.customer.model.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, String>{

}
