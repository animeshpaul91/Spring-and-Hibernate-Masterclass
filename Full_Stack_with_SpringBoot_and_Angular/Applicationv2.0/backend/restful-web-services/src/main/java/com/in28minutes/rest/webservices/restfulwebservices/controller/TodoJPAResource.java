package com.in28minutes.rest.webservices.restfulwebservices.controller;

import com.in28minutes.rest.webservices.restfulwebservices.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJPAResource {

	private final TodoJpaRepository todoJpaRepository;

	@Autowired
	public TodoJPAResource(TodoJpaRepository todoJpaRepository) {
		this.todoJpaRepository = todoJpaRepository;
	}

	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return todoJpaRepository.findByUsername(username);
	}

	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable Long id) {
		return todoJpaRepository.findById(id).get();
	}

	// DELETE
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		// we need response entity because we are not returning any content
		todoJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build(); // successful delete sends a response with no content (HTTP code 204)
	}

	// ADD/ CREATE
	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {
		todo.setId(-1L);
		todo.setUsername(username);
		Todo createdTodo = todoJpaRepository.save(todo);

		// Append {id} to current Resource URI i.e http://localhost:8080/users/{username}/todos/{id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	// UPDATE
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody Todo todo) {
		Todo todoUpdated = todoJpaRepository.save(todo);
		todoUpdated.setUsername(username);
		return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
	}

}
