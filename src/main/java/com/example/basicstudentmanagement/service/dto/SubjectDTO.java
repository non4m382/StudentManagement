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
public class SubjectDTO {

    private Long id;

    private String name;

    private LocalDate untilDate;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;

    private int minStudent;

    private TeacherDTO teacher;

    private RoomDTO room;

//    Set<SubjectStudentDTO> subjectStudents;
}
