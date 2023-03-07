package com.minutes.rest.microservices.restfulwebservices.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping(path = "/users")
    List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    User getUser(@PathVariable Integer id) {
        return userDaoService.findOne(id);
    }

    @PostMapping(path = "/users")
    void saveUser(@RequestBody User user) {
        userDaoService.save(user);
    }
}
