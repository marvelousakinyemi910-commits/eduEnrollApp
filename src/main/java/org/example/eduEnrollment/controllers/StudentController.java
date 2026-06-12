package org.example.eduEnrollment.controllers;


import lombok.RequiredArgsConstructor;
import org.example.eduEnrollment.dtos.requests.StudentRequest;
import org.example.eduEnrollment.dtos.responses.StudentResponse;
import org.example.eduEnrollment.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/create-student")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.createStudent(request));
    }

    @GetMapping("/get-student/{id}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable String id) {

        return ResponseEntity.ok(
                studentService.getStudentById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponse>>getAllStudents() {

        return ResponseEntity.ok(
                studentService.getAllStudents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {

        studentService.deleteStudent(id);

        return ResponseEntity.ok(
                "Student deleted successfully");
    }
}
