package com.employee.model;

import lombok.Data;

public @Data class EmpRequest {

	private String firstName;
	private String lastName;
	private String street;
	private String address;
	private String city;
	private String state;
	private String email;
	private String phone;
	
}
