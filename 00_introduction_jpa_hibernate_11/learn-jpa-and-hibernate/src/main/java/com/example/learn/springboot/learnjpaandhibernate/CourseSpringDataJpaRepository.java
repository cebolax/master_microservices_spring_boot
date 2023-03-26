package com.example.learn.springboot.learnjpaandhibernate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Integer> {
}
