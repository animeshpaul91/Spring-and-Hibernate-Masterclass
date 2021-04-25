package com.in28minutes.rest.webservices.restfulwebservices.HelloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }

    @RestController
    @CrossOrigin(origins = "http://localhost:4200")
    public static class HelloWorldController {
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

        @GetMapping(path="/hello-world/path-variable/{name}")
        public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
            return new HelloWorldBean(String.format("Hello World, %s", name)); // jackson performs conversion
        }
    }
}
