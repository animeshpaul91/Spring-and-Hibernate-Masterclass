package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showLanding() {
		return "landing";
	}
	
	@GetMapping("/employees")
	public String showEmployees() {
		return "employees";
	}

	// add another mapping for leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
	// add another mapping for leaders
	@GetMapping("/systems")
	public String showSystems() {
		return "systems";
	}
}
