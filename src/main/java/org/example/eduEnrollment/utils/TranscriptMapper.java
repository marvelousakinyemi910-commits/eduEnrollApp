package org.example.eduEnrollment.utils;

import org.example.eduEnrollment.data.models.Course;
import org.example.eduEnrollment.data.models.Registration;
import org.example.eduEnrollment.dtos.responses.TranscriptResponse;
import org.springframework.stereotype.Component;


@Component
public class TranscriptMapper {

    public TranscriptResponse toResponse(
            Registration registration,
            Course course) {

        return TranscriptResponse.builder()
                .courseCode(
                        course.getCourseCode())
                .courseName(
                        course.getCourseName())
                .grade(
                        registration.getGrade())
                .credits(
                        course.getCredits())
                .build();
    }
}
