package com.example.basicstudentmanagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {

    private Long id;

    private String name;

    private int quantity;

//    private Set<SubjectDTO> subjects;
}
