package com.example.basicstudentmanagement.repository;

import com.example.basicstudentmanagement.model.SubjectStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectStudentRepository extends JpaRepository<SubjectStudent, Long> {

    @Query(value = "select count(*) as count \n" +
            "from (select distinct registered_date, status, student_id, subject_id\n" +
            "\tfrom subject_student\n" +
            "\twhere registered_date in (select max(registered_date) from subject_student where subject_id = :subjectId group by student_id) and subject_id = :subjectId) A\n" +
            "where A.status = :status", nativeQuery = true)
    int countSubjectStudentBySubjectIdAndStatus(@Param("subjectId") Long subjectId, @Param("status") String status);
}
