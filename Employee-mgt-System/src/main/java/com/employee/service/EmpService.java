package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repo.EmpRepo;

@Service
public class EmpService {
@Autowired
	private EmpRepo empRepo;
	public void addEmp(Employee e) {
		empRepo.save(e);
	}
	
	
	public List<Employee> getAll() {
	 return	empRepo.findAll();
	}
	
	public Employee getEmpId(int id) {
		Optional<Employee> e= empRepo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
	return null;
}
	public void deleteEmp(int id) {
		empRepo.deleteById(id);
	}
	
	
}