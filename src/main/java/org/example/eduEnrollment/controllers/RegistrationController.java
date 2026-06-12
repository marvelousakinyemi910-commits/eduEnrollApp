package org.example.eduEnrollment.controllers;

import lombok.RequiredArgsConstructor;
import org.example.eduEnrollment.dtos.requests.RegistrationRequest;
import org.example.eduEnrollment.dtos.responses.RegistrationResponse;
import org.example.eduEnrollment.services.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService
            registrationService;

    @PostMapping("/register")
    public ResponseEntity<RegistrationResponse>registerCourse(@RequestBody RegistrationRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(registrationService
                        .registerCourse(request));
    }

    @DeleteMapping("/{studentId}/{courseId}")
    public ResponseEntity<String> dropCourse(
            @PathVariable String studentId,
            @PathVariable String courseId) {

        registrationService.dropCourse(
                studentId,
                courseId);

        return ResponseEntity.ok(
                "Course dropped successfully");
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<RegistrationResponse>>getStudentCourses(@PathVariable String studentId) {

        return ResponseEntity.ok(
                registrationService
                        .getStudentCourses(studentId));
    }

    @PutMapping("/approve/{registrationId}")
    public ResponseEntity<String>
    approveRegistration(
            @PathVariable String registrationId) {

        registrationService
                .approveRegistration(
                        registrationId);

        return ResponseEntity.ok(
                "Registration approved");
    }

    @PutMapping("/reject/{registrationId}")
    public ResponseEntity<String>rejectRegistration(@PathVariable String registrationId) {

        registrationService
                .rejectRegistration(
                        registrationId);

        return ResponseEntity.ok(
                "Registration rejected");
    }
}
