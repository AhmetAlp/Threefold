package com.threefold.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threefold.customer.model.Response;
import com.threefold.customer.repository.ResponseRepository;

@Service
public class ResponseService {
	@Autowired
	private ResponseRepository responseRepository;

	public Response createResponse(Response response) {
		return responseRepository.save(response);
	}
	
}
