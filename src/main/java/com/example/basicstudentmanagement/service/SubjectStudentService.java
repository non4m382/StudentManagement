package com.example.basicstudentmanagement.service;

import com.example.basicstudentmanagement.model.SubjectStudent;

import java.util.List;

public interface SubjectStudentService {
    List<SubjectStudent> getAllSubjectStudents();

    SubjectStudent getSubjectStudentById(Long id);

    SubjectStudent saveSubjectStudent(SubjectStudent subjectStudent);

    void deleteSubjectStudentById(Long id);

    int countSubjectStudentBySubjectIdAndStatus(Long subjectId, String status);

    String checkSavedSubjectStudent(SubjectStudent subjectStudent);
}
