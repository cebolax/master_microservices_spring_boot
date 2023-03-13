package com.minutes.rest.microservices.restfulwebservices.versioning;

public class PersonV1 {
    private final String name;

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
