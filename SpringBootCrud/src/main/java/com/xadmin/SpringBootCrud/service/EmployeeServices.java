package com.xadmin.SpringBootCrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xadmin.SpringBootCrud.bean.Employee;
import com.xadmin.SpringBootCrud.repository.EmployeeRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
	
	@Autowired
	public EmployeeRepo employeeRepo;

	public List<Employee> getAllEmployee(){
		
		List<Employee> employees= new ArrayList<>();
		employeeRepo.findAll().forEach(employees::add);
		return employees;
		
	}
	public Optional<Employee> getEmployee(Long id) {
		
		return employeeRepo.findById(id);
		
		
	}

	public void addEmployee(Employee employee) {
		
		employeeRepo.save(employee);
		
	}

	public void updateEmployee(Long id, Employee employee) {
		
		employeeRepo.save(employee);
		
	}

	public void deleteEmployee(Long id) {
		
		employeeRepo.deleteById(id);
		
	}
}
