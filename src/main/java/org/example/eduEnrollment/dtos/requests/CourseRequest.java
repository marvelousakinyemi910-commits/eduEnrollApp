package org.example.eduEnrollment.dtos.requests;

import lombok.Data;

@Data
public class CourseRequest {
    private String courseCode;

    private String courseName;

    private String description;

    private Integer credits;

    private Integer maxStudents;

    private String schedule;

    private String lecturerId;
}
