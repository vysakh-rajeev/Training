package com.xadmin.SpringBootCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

import com.xadmin.SpringBootCrud.bean.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	

}
