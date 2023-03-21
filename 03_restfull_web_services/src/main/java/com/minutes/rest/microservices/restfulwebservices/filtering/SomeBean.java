package com.minutes.rest.microservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"field1", "field3"})
public record SomeBean(String field1, String field2, String field3) {
}
