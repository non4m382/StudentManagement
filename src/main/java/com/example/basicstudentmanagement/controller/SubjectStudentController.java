package com.example.basicstudentmanagement.controller;

import com.example.basicstudentmanagement.mapper.SubjectStudentMapper;
import com.example.basicstudentmanagement.model.SubjectStudent;
import com.example.basicstudentmanagement.service.dto.SubjectStudentDTO;
import com.example.basicstudentmanagement.service.impl.SubjectStudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/subjects_students")
public class SubjectStudentController {

    private final SubjectStudentServiceImpl service;

    SubjectStudentMapper mapper;

    public SubjectStudentController(SubjectStudentServiceImpl service, SubjectStudentMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<SubjectStudentDTO> getAllSubjectStudents() {
        return service.getAllSubjectStudents().stream()
                .map(subjectStudent -> mapper.INSTANCE.subjectStudentToSubjectStudentDTO(subjectStudent))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SubjectStudentDTO getSubjectStudentById(@PathVariable Long id) {
        return mapper.subjectStudentToSubjectStudentDTO(service.getSubjectStudentById(id));
    }

    @GetMapping("/count/{id}")
    public int count(@PathVariable Long id) {
        return service.countSubjectStudentBySubjectIdAndStatus(id, "registering");
    }


    @PostMapping
    public String addSubjectStudent(@Valid @RequestBody SubjectStudentDTO subjectStudentDTO) {
        SubjectStudent subjectStudent = mapper.subjectStudentDTOToSubjectStudent(subjectStudentDTO);
        return service.checkSavedSubjectStudent(subjectStudent);
    }

    @DeleteMapping("/{id}")
    public void deleteRoomById(@PathVariable Long id) {
        service.deleteSubjectStudentById(id);
    }



}
