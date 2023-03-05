package com.minutes.rest.microservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    // GetMapping(path = "/hello")
    public String helloWorld() {
        return "HelloWorld";
    }

    @GetMapping(path = "/helloBean")
    public HelloBean helloBean() {
        return new HelloBean("my custom message");
    }

    // Path Parameters
    // /user/{id}/todos/{id} -> /user/10/todos/10
    // /helloBean/{name}
    // /helloBean/Guilv
    @GetMapping(path = "/helloBean/{name}")
    public HelloBean helloBeanPathVariable(@PathVariable String name) {
        return new HelloBean(String.format("hello, %s", name));
    }
}
