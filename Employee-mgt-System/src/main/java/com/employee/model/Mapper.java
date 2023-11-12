package com.employee.model;

import com.employee.entity.Employee;

public class Mapper {

public com.employee.entity.Employee map(EmpRequest req) {
		
		Employee e= new Employee();
		e.setFirstName(req.getFirstName());
		e.setLastName(req.getLastName());
		e.setCity(req.getCity());
		e.setAddress(req.getAddress());
		e.setEmail(req.getEmail());
		e.setPhone(req.getPhone());
		e.setState(req.getState());
		e.setStreet(req.getStreet());
		
		return e;
	}
}
