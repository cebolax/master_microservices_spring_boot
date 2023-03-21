package com.minutes.rest.microservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({"field1", "field3"})

@JsonFilter("SomeBeanFilter")
public record SomeBean(String field1, String field2, String field3) {
}
