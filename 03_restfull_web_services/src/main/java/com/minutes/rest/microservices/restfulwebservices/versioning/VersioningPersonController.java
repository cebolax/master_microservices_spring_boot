package com.minutes.rest.microservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    // URL

    @GetMapping(path = "/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob bob");
    }

    @GetMapping(path = "/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2(new Name("boa", "bob"));
    }

    // PARAMS

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonWithParams() {
        return new PersonV1("Bob bob");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonWithParams() {
        return new PersonV2(new Name("boa", "bob"));
    }

    // HEADER

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonWithHeaders() {
        return new PersonV1("Bob bob");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonWithHeaders() {
        return new PersonV2(new Name("boa", "bob"));
    }


    // ACCEPT HEADER

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonWithAcceptHeaders() {
        return new PersonV1("Bob bob");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonWithAcceptHeaders() {
        return new PersonV2(new Name("boa", "bob"));
    }
}
