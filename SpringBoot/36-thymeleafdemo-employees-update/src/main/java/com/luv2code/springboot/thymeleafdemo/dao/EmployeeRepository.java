package com.luv2code.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { // <Entity, PrimaryKey>
	 // no need to write any code
	
	// add a custom method to sort employees by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
