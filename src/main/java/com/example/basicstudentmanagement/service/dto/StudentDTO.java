package com.example.basicstudentmanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private boolean gender;

    private LocalDate dob;

    private String phone;

    private String email;

    private String address;

//    Set<SubjectStudentDTO> subjectStudents;
}
