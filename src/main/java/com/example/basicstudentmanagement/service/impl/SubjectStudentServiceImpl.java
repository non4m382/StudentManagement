package com.example.basicstudentmanagement.service.impl;

import com.example.basicstudentmanagement.model.Subject;
import com.example.basicstudentmanagement.model.SubjectStudent;
import com.example.basicstudentmanagement.repository.SubjectStudentRepository;
import com.example.basicstudentmanagement.service.SubjectStudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubjectStudentServiceImpl implements SubjectStudentService {
    private SubjectStudentRepository repository;
    private SubjectServiceImpl subjectService;

    public SubjectStudentServiceImpl(SubjectStudentRepository repository, SubjectServiceImpl subjectService) {
        this.repository = repository;
        this.subjectService = subjectService;
    }

    @Override
    public List<SubjectStudent> getAllSubjectStudents() {
        return repository.findAll();
    }

    @Override
    public SubjectStudent getSubjectStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public SubjectStudent saveSubjectStudent(SubjectStudent subjectStudent) {
        LocalDateTime localDateTime = LocalDateTime.now();
        subjectStudent.setRegisteredDate(localDateTime);
        return repository.save(subjectStudent);
    }

    @Override
    public void deleteSubjectStudentById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public int countSubjectStudentBySubjectIdAndStatus(Long subjectId, String status) {
        return repository.countSubjectStudentBySubjectIdAndStatus(subjectId, status);
    }

    @Override
    public String checkSavedSubjectStudent(SubjectStudent subjectStudent) {
        Subject subject = subjectStudent.getSubject();
        String status = subject.getStatus();
        String result = "";
        if (status.equals("open")) {
            saveSubjectStudent(subjectStudent);
            result = "Save successfully";
        }
        else {
            result = "Cannot register";
        }
        return  result;
    }
}
