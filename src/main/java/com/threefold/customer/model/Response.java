package com.threefold.customer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Response")
public class Response {
    @Id
    private String id;
	private int code;
	private String status;
	private String message;
	private String payload;
	
	public Response() {
		
	}
	
	public Response(int code, String status, String message, String payload) {
		this.code = code;
		this.status = status;
		this.message = message;
		this.payload = payload;		
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("response[");
		sb.append("id=");
		sb.append(id);
		sb.append(",code=");
		sb.append(code);
		sb.append(",status=");
		sb.append(status);
		sb.append(",message=");
		sb.append(message);
		sb.append(",payload=");
		sb.append(payload);
		sb.append("]");		
		return sb.toString();
	}	
	
}
