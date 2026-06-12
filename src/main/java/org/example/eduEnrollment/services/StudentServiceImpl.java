package org.example.eduEnrollment.services;

import lombok.RequiredArgsConstructor;
import org.example.eduEnrollment.data.models.Student;
import org.example.eduEnrollment.data.models.User;
import org.example.eduEnrollment.data.repositories.StudentRepository;
import org.example.eduEnrollment.data.repositories.UserRepository;
import org.example.eduEnrollment.dtos.requests.StudentRequest;
import org.example.eduEnrollment.dtos.responses.StudentResponse;
import org.example.eduEnrollment.utils.StudentMapper;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponse createStudent(StudentRequest request) {

//        Student student =
        User user = userRepository.findById(
                        request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found"));

        Student student =
                studentMapper.toEntity(request);
//
        Student savedStudent =
                studentRepository.save(student);

        return studentMapper.toResponse(
                savedStudent);
    }

    @Override
    public StudentResponse getStudentById(
            String studentId) {

        Student student =
                studentRepository.findById(studentId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Student not found"));

        return studentMapper.toResponse(
                student);
    }

    @Override
    public List<StudentResponse>
    getAllStudents() {

        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteStudent(
            String studentId) {

        Student student =
                studentRepository.findById(studentId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Student not found"));

        studentRepository.delete(student);
    }
}
