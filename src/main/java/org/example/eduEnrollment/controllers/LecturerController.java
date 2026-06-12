package org.example.eduEnrollment.controllers;

import lombok.RequiredArgsConstructor;
import org.example.eduEnrollment.dtos.requests.LecturerRequest;
import org.example.eduEnrollment.dtos.responses.LecturerResponse;
import org.example.eduEnrollment.services.LecturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class LecturerController {

    private final LecturerService lecturerService;

    @PostMapping("/create-instructor")
    public ResponseEntity<LecturerResponse>createInstructor(@RequestBody LecturerRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(lecturerService
                        .createLecturer(request));
    }

    @GetMapping("/get-instructions")
    public ResponseEntity<List<LecturerResponse>>getAllInstructors() {

        return ResponseEntity.ok(
                lecturerService.getAllLecturers());
    }

    @DeleteMapping("/delete-instructor/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable String id) {

        lecturerService.deleteLecturer(id);

        return ResponseEntity.ok(
                "Instructor deleted successfully");
    }
}
