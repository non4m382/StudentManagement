package com.example.basicstudentmanagement;

import com.example.basicstudentmanagement.service.impl.SubjectServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicStudentManagementApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BasicStudentManagementApplication.class, args);
        SubjectServiceImpl subjectService = context.getBean(SubjectServiceImpl.class);
        int min = subjectService.getMinStudentBySubjectId(1L);

        System.out.println(min);

    }

}
