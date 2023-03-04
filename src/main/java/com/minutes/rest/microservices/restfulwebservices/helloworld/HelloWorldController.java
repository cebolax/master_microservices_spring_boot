package com.minutes.rest.microservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    // GetMapping(path = "/hello")
    public String helloWorld() {
        return "HelloWorld";
    }
}