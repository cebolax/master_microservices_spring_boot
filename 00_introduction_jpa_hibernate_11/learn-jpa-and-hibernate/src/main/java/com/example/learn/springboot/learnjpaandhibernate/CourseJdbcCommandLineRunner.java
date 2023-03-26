package com.example.learn.springboot.learnjpaandhibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    CourseSpringDataJpaRepository repository;
//    CourseJpaRepository repository;
    //CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Guil", "V"));
        repository.save(new Course(2, "Guil", "VV"));
        repository.save(new Course(3, "Guil", "VVV"));

        repository.deleteById(2);

        var course = repository.findById(3);
        System.out.println(course);
    }
}
