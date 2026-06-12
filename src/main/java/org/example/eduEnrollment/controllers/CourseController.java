package org.example.eduEnrollment.controllers;

import lombok.RequiredArgsConstructor;
import org.example.eduEnrollment.dtos.requests.CourseRequest;
import org.example.eduEnrollment.dtos.responses.CourseResponse;
import org.example.eduEnrollment.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/create-course")
    public ResponseEntity<CourseResponse>createCourse(@RequestBody CourseRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService
                        .createCourse(request));
    }

    @PutMapping("/update-course/{id}")
    public ResponseEntity<CourseResponse>updateCourse(@PathVariable String id,  @RequestBody CourseRequest request) {

        return ResponseEntity.ok(
                courseService
                        .updateCourse(id, request));
    }

    @GetMapping("/get-all-courses")
    public ResponseEntity<List<CourseResponse>>getAllCourses() {

        return ResponseEntity.ok(
                courseService.getAllCourses());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable String id) {

        courseService.deleteCourse(id);

        return ResponseEntity.ok(
                "Course deleted successfully");
    }
}
