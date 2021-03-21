package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;

	// add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers(); // jackson converts List of POJOs to JSON
	}

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) throws Throwable {
		Customer customer = customerService.getCustomer(customerId);

		if (customer == null)
			throw new CustomerNotFoundException("Customer Id: " + customerId + " not found");

		return customer; // jackson converts POJO to JSON
	}
	
	// add mapping for POST /customers - add new customer
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer customer) { // @RequestBody converts incoming JSON to POJO
		// also just in case the user passes an id, we will set it to 0
		// this will force save of a new item instead of update bcz hibernate treats 0 as empty ID
		customer.setId(0);
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
}
