package com.in28minutes.rest.webservices.restfulwebservices.controller;

import com.in28minutes.rest.webservices.restfulwebservices.entity.Todo;
import com.in28minutes.rest.webservices.restfulwebservices.service.TodoHardCodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TodoResource {

    private final TodoHardCodedService todoHardCodedService;

    @Autowired
    public TodoResource(TodoHardCodedService todoHardCodedService) {
        this.todoHardCodedService = todoHardCodedService;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoHardCodedService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable Long id) {
        return todoHardCodedService.findById(id);
    }

    // DELETE
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) { // we need response entity because we are not returning any content
        Todo todo = todoHardCodedService.deleteById(id);
        if (todo != null) return ResponseEntity.noContent().build(); // successful delete sends a response with no content (HTTP code 204)
        return ResponseEntity.notFound().build();
    }

    // ADD/ CREATE
    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setId(-1L);
        Todo createdTodo = todoHardCodedService.save(todo);

        // Append {id} to current Resource URI i.e http://localhost:8080/users/{username}/todos/{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    // UPDATE
    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
        Todo todoUpdated = todoHardCodedService.save(todo);
        return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);
    }

}
