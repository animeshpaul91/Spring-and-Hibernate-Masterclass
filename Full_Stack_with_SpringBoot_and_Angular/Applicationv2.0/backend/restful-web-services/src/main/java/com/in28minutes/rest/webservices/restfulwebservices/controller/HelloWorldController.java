package com.in28minutes.rest.webservices.restfulwebservices.controller;

import com.in28minutes.rest.webservices.restfulwebservices.Beans.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    // GET Method
    // URI - /hello-world
    // method -- "Hello World"

    @GetMapping(path="/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World"); // jackson performs conversion
    }
}
