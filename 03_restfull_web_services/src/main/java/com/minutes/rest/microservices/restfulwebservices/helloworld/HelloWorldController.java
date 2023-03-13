package com.minutes.rest.microservices.restfulwebservices.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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

    @GetMapping(path = "/helloI18n")
    public String helloI18n() {
        return messageSource.getMessage(
                "hello.message",
                null,
                "HEllo Hello",
                LocaleContextHolder.getLocale()
        );
    }
}
