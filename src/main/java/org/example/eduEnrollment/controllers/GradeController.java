package org.example.eduEnrollment.controllers;

import lombok.RequiredArgsConstructor;
import org.example.eduEnrollment.dtos.requests.GradeRequest;
import org.example.eduEnrollment.dtos.responses.TranscriptResponse;
import org.example.eduEnrollment.services.GradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/grades")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    @PostMapping
    public ResponseEntity<String> assignGrade(
            @RequestBody GradeRequest request) {

        gradeService.assignGrade(request);

        return ResponseEntity.ok(
                "Grade assigned successfully");
    }

    @GetMapping("/transcript/{studentId}")
    public ResponseEntity<List<TranscriptResponse>>
    getTranscript(
            @PathVariable String studentId) {

        return ResponseEntity.ok(
                gradeService
                        .getTranscript(studentId));
    }
}
