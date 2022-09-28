package com.example.basicstudentmanagement.mapper;

import com.example.basicstudentmanagement.model.SubjectStudent;
import com.example.basicstudentmanagement.service.dto.SubjectStudentDTO;
import com.example.basicstudentmanagement.service.impl.StudentServiceImpl;
import com.example.basicstudentmanagement.service.impl.SubjectServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {StudentServiceImpl.class, SubjectServiceImpl.class})
public interface SubjectStudentMapper
//        extends BaseMapper<SubjectStudent, SubjectStudentDTO>
{
    SubjectStudentMapper INSTANCE = Mappers.getMapper(SubjectStudentMapper.class);

    @Mapping(target = "studentId", source = "student.id")
    @Mapping(target = "subjectId", source = "subject.id")
    SubjectStudentDTO subjectStudentToSubjectStudentDTO(SubjectStudent subjectStudent);

//    @Mapping(target = "id", source = "student.id")
//    @Mapping(target = "subjectId", source = "subject.id")
    @Mapping(target = "student", source = "studentId")
    @Mapping(target = "subject", source = "subjectId")
    SubjectStudent subjectStudentDTOToSubjectStudent(SubjectStudentDTO subjectStudentDTO);
}
