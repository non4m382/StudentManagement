package com.example.basicstudentmanagement.mapper;

import com.example.basicstudentmanagement.model.Teacher;
import com.example.basicstudentmanagement.service.dto.TeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher, TeacherDTO> {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);
}
