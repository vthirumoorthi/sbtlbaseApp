package com.sbtl.smartweaver.business.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.sbtl.smartweaver.data.entity.Employee;
import com.sbtl.smartweaver.data.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	 
	private EmployeeRepository employeeRepository;
	
	@Autowired
	    public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

		public Iterable<Employee> listAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    public Optional<Employee> getClothTypeById(long id) {
	        return employeeRepository.findById(id);
	    }
	
	    public Employee saveEmployee(Employee empdetail) {
	        return employeeRepository.save(empdetail);
	    }

	    public void deleteEmployee(long id) {
	    	employeeRepository.deleteById(id);
	    }
}
