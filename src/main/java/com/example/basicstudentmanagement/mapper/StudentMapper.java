package com.example.basicstudentmanagement.mapper;

import com.example.basicstudentmanagement.model.Student;
import com.example.basicstudentmanagement.service.dto.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper extends BaseMapper<Student, StudentDTO> {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
}
