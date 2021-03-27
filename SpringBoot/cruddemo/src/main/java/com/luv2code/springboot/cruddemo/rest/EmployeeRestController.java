package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api") // base mapping
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// expose "/employees" and return list of all employees
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	// add mapping for GET /employee/{employeeId}
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);

		if (employee == null)
			throw new RuntimeException("Employee Id not found - " + employeeId);

		return employee;
	}

	@PostMapping("/employee/new")
	public Employee addEmployee(@RequestBody Employee employee) {
		// also just in case they pass an ID in the data payload
		employee.setId(0); // force insert to DB
		employeeService.save(employee);
		return employee;
	}

	// add mapping for PUT /employees - update existing employee
	@PutMapping("/employee/{employeeId}")
	public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee) {
		employee.setId(employeeId);
		employeeService.save(employee);
		return employee;
	}
	
	// add mapping for DELETE /employee/{employeeId} - delete employee
	@DeleteMapping("/employee/{employeeId}") 
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		
		if (employee == null)
			throw new RuntimeException("Employee Id not found - " + employeeId);
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee Id - " + employeeId;
	}

}
