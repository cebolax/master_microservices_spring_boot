package com.minutes.rest.microservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class UserController {

    private final UserDaoService userDaoService;

    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User getUser(@PathVariable Integer id) {
        var user = userDaoService.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id : " + id);
        }
        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        var createdUser = userDaoService.save(user);

        var location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        // Header - Location: http://localhost:8080/users/{id}
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userDaoService.deleteById(id);
    }
}
