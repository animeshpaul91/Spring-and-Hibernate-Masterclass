package com.in28minutes.rest.webservices.restfulwebservices.controller;

import com.in28minutes.rest.webservices.restfulwebservices.entity.Todo;
import com.in28minutes.rest.webservices.restfulwebservices.service.TodoHardCodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // DELETE
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) { // we need response entity because we are not returning any content
        Todo todo = todoHardCodedService.deleteById(id);
        if (todo != null) return ResponseEntity.noContent().build(); // successful delete sends a response with no content (HTTP code 204)
        return ResponseEntity.notFound().build();
    }

}
