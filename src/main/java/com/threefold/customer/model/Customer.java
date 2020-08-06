package com.threefold.customer.model;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer {

    @Id
    private String idNumber;
    
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    @Indexed(unique = true)
    private String email;

    private String initials;
    
    @NotBlank
    private String mobile;
    
    private long lastupdated;

	public String getIdNumber() {
		return idNumber;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public String getInitials() {
		return initials;
	}

	public String getMobile() {
		return mobile;
	}

	public long getLastupdated() {
		return lastupdated;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setLastupdated(long lastupdated) {
		this.lastupdated = lastupdated;
	}    

}
