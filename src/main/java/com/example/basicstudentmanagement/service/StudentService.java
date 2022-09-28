package com.example.basicstudentmanagement.service;

import com.example.basicstudentmanagement.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student findStudentById(Long id);
//    SubjectDTO convertEntityToDto(Subject subject);

    Student saveStudent(Student student);

    void deleteStudentById(Long id);
}
