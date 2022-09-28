package com.example.basicstudentmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private LocalDate untilDate;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @NotBlank
    @Size(max = 10)
    private String status;
    @NotNull
    @Min(1)
    private int minStudent;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
//    @JsonBackReference
    @NotNull
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "room_id")
//    @JsonBackReference
    @NotNull
    private Room room;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subject")
//    @JsonManagedReference
    Set<SubjectStudent> subjectStudents;
}
