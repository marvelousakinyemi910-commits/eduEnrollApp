package org.example.eduEnrollment.utils;

import org.example.eduEnrollment.data.models.Student;
import org.example.eduEnrollment.dtos.requests.StudentRequest;
import org.example.eduEnrollment.dtos.responses.StudentResponse;
import org.springframework.stereotype.Component;


@Component
public class StudentMapper {

    public Student toEntity(StudentRequest request) {

        Student student = new Student();

        student.setDepartment(request.getDepartment());
        student.setLevel(request.getLevel());
        student.setMatricNumber(request.getMatricNumber());
        student.setUserId(request.getUserId());

        return student;

    }

    public StudentResponse toResponse(Student student) {

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setId(student.getId());
        studentResponse.setDepartment(student.getDepartment());
        studentResponse.setLevel(student.getLevel());
        studentResponse.setMatricNumber(student.getMatricNumber());

        return studentResponse;

    }
}