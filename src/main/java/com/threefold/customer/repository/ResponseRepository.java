package com.threefold.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.threefold.customer.model.Response;

@Repository
public interface ResponseRepository extends MongoRepository<Response, String>{

}
