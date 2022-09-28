package com.example.basicstudentmanagement.controller;

import com.example.basicstudentmanagement.mapper.SubjectMapper;
import com.example.basicstudentmanagement.model.Subject;
import com.example.basicstudentmanagement.service.dto.SubjectDTO;
import com.example.basicstudentmanagement.service.impl.SubjectServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectController {
    private final SubjectServiceImpl service;
    SubjectMapper mapper;

    public SubjectController(SubjectServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<SubjectDTO> getAllSubjects() {
        List<Subject> subjects = service.getAllSubjects();
        for (Subject subject : subjects) {
            service.checkCurrentSubjectStatus(subject);
        }
        return subjects.stream().map(subject -> mapper.INSTANCE.entityToDTO(subject))
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public SubjectDTO getSubjectById(@PathVariable Long id) {
        Subject subject = service.findSubjectById(id);
        return mapper.INSTANCE.entityToDTO(subject);
    }

    @GetMapping("{id/students}")
    public SubjectDTO getStudentsBySubjectId(@PathVariable Long id) {
        Subject subject = service.findSubjectById(id);
        return mapper.INSTANCE.entityToDTO(subject);
    }

    @PostMapping
    public ResponseEntity<Void> addSubject(@Valid @RequestBody SubjectDTO subjectDTO) {
        Subject subject = mapper.INSTANCE.DTOToEntity(subjectDTO);
        service.saveSubject(subject);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
