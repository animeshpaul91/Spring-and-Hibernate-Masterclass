package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// Add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException customerNotFoundException) {

		// create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
				customerNotFoundException.getMessage(), System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	// Add another exception handler for any other type of Exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exception) {

		// create CustomerErrorResponse
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),
				"Bad Input Parameter", System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<CustomerErrorResponse>(error, HttpStatus.BAD_REQUEST); // ResponseEntity is just a HTTP Response Wrapper in Java
	}
}
