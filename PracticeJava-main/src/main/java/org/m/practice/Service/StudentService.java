package org.m.practice.Service;

import org.m.practice.Entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> GetAllStudents();
    Student saveStudent(Student student);
    Student getByID(Long id);
    Student updateStudent(Student student);
    void deleteStudentById(Long id);
}
