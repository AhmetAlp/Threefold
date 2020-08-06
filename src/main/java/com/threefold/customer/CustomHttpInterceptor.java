package com.threefold.customer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.threefold.customer.model.Response;
import com.threefold.customer.service.ResponseService;

@Component
public class CustomHttpInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(CustomHttpInterceptor.class);
	
	@Autowired
	private ResponseService responseService;

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
            final Object handler, final Exception ex) {
        String status = response.getStatus() == HttpStatus.OK.value() ? "OK":"ERROR";
    	Response resp = new Response(response.getStatus(),status,"","");

	    ObjectMapper mapper = new ObjectMapper();
	    JsonFactory factory = mapper.getFactory();
	    JsonParser parser;
		try {
			parser = factory.createParser(new String(wrapResponse(response).getContentAsByteArray()));
		    JsonNode jNode = mapper.readTree(parser);
		    if (jNode != null) {
			    if (jNode.get("message") != null) { 
			    	resp.setMessage(jNode.get("message").asText());
			    	resp.setPayload("[]");		    	
			    } else if (jNode.get("content") != null) {
			    	resp.setPayload(jNode.get("content").toString());		    	
			    } else if (jNode.get("idNumber") != null && jNode.get("lastupdated") != null) {
			    	resp.setPayload("[" + jNode.toString() + "]");
			    }
				responseService.createResponse(resp);
		    }
		} catch (IOException e) {
			logger.error("Can not write response log to mongodb: {}", resp);
		}
        
    }


	private static ContentCachingResponseWrapper wrapResponse(HttpServletResponse response) {
        if (response instanceof ContentCachingResponseWrapper) {
            return (ContentCachingResponseWrapper) response;
        } else {
            return new ContentCachingResponseWrapper(response);
        }
    }
}