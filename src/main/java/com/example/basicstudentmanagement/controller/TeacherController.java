package com.example.basicstudentmanagement.controller;

import com.example.basicstudentmanagement.mapper.TeacherMapper;
import com.example.basicstudentmanagement.service.dto.TeacherDTO;
import com.example.basicstudentmanagement.service.impl.TeacherServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {
    TeacherMapper teacherMapper;

    private final TeacherServiceImpl teacherServicer;

    public TeacherController(TeacherServiceImpl teacherServicer) {
        this.teacherServicer = teacherServicer;
    }

    @GetMapping
    public List<TeacherDTO> getAllTeachers() {
        return teacherServicer.getAllTeachers().stream().map(teacher -> teacherMapper.INSTANCE.entityToDTO(teacher))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TeacherDTO getTeacherById(@PathVariable Long id) {
        return teacherMapper.INSTANCE.entityToDTO(teacherServicer.getTeacherById(id));
    }

    @PostMapping()
    public ResponseEntity<Void> addTeacher(@Valid @RequestBody TeacherDTO teacherDTO) {
        teacherServicer.saveTeacher(teacherMapper.INSTANCE.DTOToEntity(teacherDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteRoomById(@PathVariable Long id) {
        teacherServicer.deleteTeacherById(id);
    }
}
