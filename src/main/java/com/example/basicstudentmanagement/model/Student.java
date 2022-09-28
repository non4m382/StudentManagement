package com.example.basicstudentmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 20)
    private String firstName;
    @NotBlank
    @Size(max = 20)
    private String lastName;
    @NotNull
    private LocalDate dob;
    @NotNull
    private boolean gender;
    @NotBlank
    @Column(unique = true)
    @Size(min = 10, max = 12)
    private String phone;
    @Email
    @Column(unique = true)
    @Size(max = 30)
    private String email;
    @NotBlank
    @Size(max = 200)
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
//    @JsonManagedReference
    Set<SubjectStudent> subjectStudents;
}
