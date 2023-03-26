package com.example.learn.springboot.learnjpaandhibernate;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @Autowired
    EntityManager entityManager;

    void save(Course course) {
        entityManager.merge(course);
    }

    void deleteById(int id) {
        var course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

    Course findById(int id) {
        return entityManager.find(Course.class, id);
    }
}
