package org.example.eduEnrollment.services;

import org.example.eduEnrollment.dtos.requests.CourseRequest;
import org.example.eduEnrollment.dtos.responses.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse createCourse(CourseRequest request);

    CourseResponse updateCourse(
            String courseId,
            CourseRequest request
    );

    List<CourseResponse> getAllCourses();

    void deleteCourse(String courseId);
}