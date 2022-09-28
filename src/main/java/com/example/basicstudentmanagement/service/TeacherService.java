package com.example.basicstudentmanagement.service;

import com.example.basicstudentmanagement.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    Teacher getTeacherById(Long id);

    Teacher saveTeacher(Teacher teacher);

    void deleteTeacherById(Long id);
}
