package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// add a mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model model) {
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "/employees/list-employees"; // templates is in classpath, because we added a custom employees directory
											// we added this prefix here
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		// create an employee to bind form data

		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "/employees/employee-form"; // template for form addition
	}
}
