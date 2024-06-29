package org.m.practice;

import org.m.practice.Entities.Student;
import org.m.practice.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PracticeApplication.class, args);
    }

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void run(String... args) throws Exception {

       // Student student1 = new Student("AArt", "TSURK","12@example");
       // studentRepository.save(student1);
    }
}
