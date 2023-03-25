package com.example.learn.springboot.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static String INSERT_QUERY = """
            INSERT INTO COURSE (id, name, author)
            VALUES (1, 'guil', 'v');
            """;

    void insert() {
        jdbcTemplate.update(INSERT_QUERY);
    }
}
