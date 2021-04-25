package com.in28minutes.rest.webservices.restfulwebservices.service;

import com.in28minutes.rest.webservices.restfulwebservices.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {

    private static final List<Todo> todos = new ArrayList<>();
    private static long idCounter = 0;

    static { // only works for static members of the class
        todos.add(new Todo(++idCounter, "in28minutes", "Learn to Dance", new Date(), false));
        todos.add(new Todo(++idCounter, "in28minutes", "Learn about Microservices", new Date(), false));
        todos.add(new Todo(++idCounter, "in28minutes", "Learn about Angular", new Date(), false));
    }

    public List<Todo> findAll() {
        return todos;
    }
}
