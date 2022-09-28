package com.example.basicstudentmanagement.service;

import com.example.basicstudentmanagement.model.Subject;

import java.util.List;

public interface SubjectService {

    List<Subject> getAllSubjects();

    Subject findSubjectById(Long id);
//    SubjectDTO convertEntityToDto(Subject subject);

    Subject saveSubject(Subject subject);

    void deleteSubject(Long id);

    int getMinStudentBySubjectId(Long id);

    String checkCurrentSubjectStatus(Subject subject);

    void updateSubjectStatus(Long id, String status);
}
