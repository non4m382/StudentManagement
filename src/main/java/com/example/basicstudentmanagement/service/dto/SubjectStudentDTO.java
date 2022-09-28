package com.example.basicstudentmanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectStudentDTO {
    Long id;

//    StudentDTO student;
//
//    SubjectDTO subject;

    private Long studentId;

    private Long subjectId;

    private String status;

    private LocalDateTime registeredDate;
}
