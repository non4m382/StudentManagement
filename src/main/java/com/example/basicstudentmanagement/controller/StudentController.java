package com.example.basicstudentmanagement.controller;

import com.example.basicstudentmanagement.mapper.StudentMapper;
import com.example.basicstudentmanagement.service.dto.StudentDTO;
import com.example.basicstudentmanagement.service.impl.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    StudentMapper mapper;

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents().stream().map(student -> mapper.INSTANCE.entityToDTO(student))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return mapper.INSTANCE.entityToDTO(studentService.findStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Void> addRoom(@Valid @RequestBody StudentDTO studentDTO) {
        studentService.saveStudent(mapper.INSTANCE.DTOToEntity(studentDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }

}
