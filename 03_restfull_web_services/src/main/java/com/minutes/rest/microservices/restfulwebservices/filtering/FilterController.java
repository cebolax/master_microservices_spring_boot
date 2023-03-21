package com.minutes.rest.microservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @GetMapping(path = "/someBean")
    public MappingJacksonValue getSomeBean() {
        var bean = new SomeBean("field1", "field2", "field3");
        var mapJacksonValue = new MappingJacksonValue(bean);

        var filter = new SimpleFilterProvider().addFilter(
                "SomeBeanFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2")
        );
        mapJacksonValue.setFilters(filter);

        return mapJacksonValue;
    }
}
