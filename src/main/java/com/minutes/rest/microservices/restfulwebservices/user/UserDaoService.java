package com.minutes.rest.microservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDaoService {
    private static final List<User> users = new ArrayList<>();

    static {
        users.addAll(Arrays.asList(
                new User(1, "Adam", LocalDate.now().minusYears(30)),
                new User(2, "Eve", LocalDate.now().minusYears(30)),
                new User(3, "Jim", LocalDate.now().minusYears(30))
        ));
    }

    // findAll
    List<User> findAll() {
        return users;
    }

    // findOne
    // save
}
