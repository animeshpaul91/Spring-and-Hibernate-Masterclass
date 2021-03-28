package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		// get thebemployee from the service
		Employee employee = employeeService.findById(id);
		// set this employee as a model attribute to pre populate the form
		model.addAttribute("employee", employee);

		// redirect to employee-form
		return "/employees/employee-form"; // template for form addition
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// save the employee
		employeeService.save(employee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list"; // POST redirect GET pattern
	}
}
