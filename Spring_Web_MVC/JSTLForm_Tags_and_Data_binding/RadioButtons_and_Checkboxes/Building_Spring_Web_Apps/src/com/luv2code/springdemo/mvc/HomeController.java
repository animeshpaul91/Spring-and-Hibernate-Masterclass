package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // is a subclass of @Component 
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		return "main-menu"; // Spring Web MVC will add the prefix and suffix automatically
	}
}
