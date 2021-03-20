package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api") // base request controller
public class StudentRestController {

	private List<Student> students;

	// define @PostConstruct to load the student data - This is called when the bean
	// is created
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("Poornima", "Patel"));
		students.add(new Student("Mario", "Rossi"));
		students.add(new Student("Mary", "Smith"));
	}

	// define an endpoint for "/students" - return a list of all students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students; // spring leverages jackson to convert list to JSON implicitly
	}

	// define endpoint for "/students/{studentId}" - return student at index

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) throws Throwable { // path Variable binds to studentId
																				// mentioned in
		// Annotation. Both have to be same
		// just index into the list -- keep it simple for now

		// check the studentId against list size
		if (studentId >= students.size() || studentId < 0)
			throw new StudentNotFoundException("Student ID not found = " + studentId);

		return students.get(studentId);
	}
	
	// Add an exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException) {
		
		// create a student Error response
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(studentNotFoundException.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND); // jackson will convert this POJO to plain JSON
	}
	
}
