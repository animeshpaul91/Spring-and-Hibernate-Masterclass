package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	// expose "/" endpoint that will return "Hello World"
	
	@Value("${coach.name}")
	private String coachName;
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on the server is: " + LocalDateTime.now();
	}
}
