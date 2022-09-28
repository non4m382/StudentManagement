package com.example.basicstudentmanagement.repository;

import com.example.basicstudentmanagement.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Subject getMinStudentById(Long id);
}
