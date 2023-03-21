package com.minutes.rest.microservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @GetMapping(path = "/someBean")
    public SomeBean getSomeBean() {
        return new SomeBean("field1", "field2", "field3");
    }
}
