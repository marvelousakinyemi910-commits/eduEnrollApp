package org.example.eduEnrollment.services;


import org.example.eduEnrollment.dtos.requests.StudentRequest;
import org.example.eduEnrollment.dtos.responses.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse createStudent(
            StudentRequest request);

    StudentResponse getStudentById(
            String studentId);

    List<StudentResponse> getAllStudents();

    void deleteStudent(
            String studentId);
}
