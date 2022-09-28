package com.example.basicstudentmanagement.service.impl;

import com.example.basicstudentmanagement.model.Teacher;
import com.example.basicstudentmanagement.repository.TeacherRepository;
import com.example.basicstudentmanagement.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository repository;

    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        repository.deleteById(id);
    }
}
