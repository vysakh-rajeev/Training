package com.xadmin.SpringBootCrud.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xadmin.SpringBootCrud.bean.Employee;
import com.xadmin.SpringBootCrud.service.EmployeeServices;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
	
	Logger logger = LoggerFactory.getLogger(Employee.class);
	
	
	@Autowired
	private EmployeeServices employeeServices; //lower-case
	
	@RequestMapping("/employees")
	public List<Employee> getAllEmployee(){
		
		logger.info("Fetching all Employee Details");
		return employeeServices.getAllEmployee();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/findemployee/{id}")
	public Optional<Employee> getEmployee(@PathVariable("id") Long empid) {
		
		logger.info("Retrieved Employee details wrt Employee id");
		return employeeServices.getEmployee(empid);
	
	}

	@RequestMapping(method = RequestMethod.POST, value="/add")
	public void addEmployee(@RequestBody Employee employee) {
		
		logger.info("Adding new Employee");
		employeeServices.addEmployee(employee);
	
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/employees/{id}")
	public void updateEmployee(@PathVariable("id") Long empid, @RequestBody Employee employee) { //testing
		
		logger.info("Updated Existing Employee Details");
		employeeServices.updateEmployee(empid,employee);
	
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		
		logger.info("Deleting employee with employee id");
		employeeServices.deleteEmployee(id);

		
	}
}
