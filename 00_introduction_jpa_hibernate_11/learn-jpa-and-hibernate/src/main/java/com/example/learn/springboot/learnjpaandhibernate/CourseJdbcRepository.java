package com.example.learn.springboot.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static String INSERT_QUERY = """
            INSERT INTO COURSE (id, name, author)
            VALUES (? , ?, ?);
            """;

    public static String DELETE_QUERY = """
            DELETE FROM COURSE 
            WHERE id = ? 
            """;

    public static String FIND_QUERY = """
            SELECT * FROM COURSE 
            WHERE id = ?
            """;

    void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    void deleteById(int id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    Course findById(int id) {
        return jdbcTemplate.queryForObject(FIND_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
