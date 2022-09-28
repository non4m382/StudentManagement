package com.example.basicstudentmanagement.mapper;

import com.example.basicstudentmanagement.model.Subject;
import com.example.basicstudentmanagement.service.dto.SubjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectMapper
        extends BaseMapper<Subject, SubjectDTO>
{

    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "name", source = "name")
//    @Mapping(target = "untilDate", source = "untilDate")
//    @Mapping(target = "startDate", source = "startDate")
//    @Mapping(target = "endDate", source = "endDate")
//    @Mapping(target = "status", source = "status")
//    @Mapping(target = "minStudent", source = "minStudent")
//    @Mapping(target = "teacherDTO", source = "teacher")
//    @Mapping(target = "roomDTO", source = "room")
//    @Mapping(target = "subjectStudents", source = "subjectStudents")
//    SubjectDTO map(Subject source);


//
//   @Mapping(source = "teacher", target = "teacherDTO")
//   SubjectDTO convert(Subject subject, Teacher teacher);
}
