package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// add exception handling code here
	// Add an exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException) {

		// create a student Error response
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(studentNotFoundException.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND); // jackson will convert this POJO
																						// to plain JSON
	}

	// add another exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
		// create a student Error response
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST); // jackson will convert this POJO
		// to plain JSON
	}
}
