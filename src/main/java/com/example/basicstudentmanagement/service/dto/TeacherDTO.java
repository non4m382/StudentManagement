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
public class TeacherDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate dob;

    private String phone;

    private String email;

//    private Set<SubjectDTO> subjects;
}
