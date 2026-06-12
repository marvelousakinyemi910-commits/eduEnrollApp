package org.example.eduEnrollment.utils;

import org.example.eduEnrollment.data.models.Course;
import org.example.eduEnrollment.dtos.requests.CourseRequest;
import org.example.eduEnrollment.dtos.responses.CourseResponse;
import org.springframework.stereotype.Component;


@Component
public class CourseMapper {

    public Course toEntity(
            CourseRequest request) {

        return Course.builder()
                .courseCode(request.getCourseCode())
                .courseName(request.getCourseName())
                .description(request.getDescription())
                .credits(request.getCredits())
                .maxStudents(request.getMaxStudents())
                .registeredStudents(0)
                .schedule(request.getSchedule())
                .lecturerId(request.getLecturerId())
                .build();
    }

    public CourseResponse toResponse(
            Course course,
            String lecturerName) {

        return CourseResponse.builder()
                .id(course.getId())
                .courseCode(course.getCourseCode())
                .courseName(course.getCourseName())
                .description(course.getDescription())
                .credits(course.getCredits())
                .maxStudents(course.getMaxStudents())
                .registeredStudents(
                        course.getRegisteredStudents())
                .schedule(course.getSchedule())
                .lecturerName(lecturerName)
                .build();
    }
}
