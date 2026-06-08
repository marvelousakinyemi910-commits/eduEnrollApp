package org.example.eduEnrollment.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseResponse {
    private String id;

    private String courseCode;

    private String courseName;

    private String description;

    private Integer credits;

    private Integer maxStudents;

    private Integer registeredStudents;

    private String schedule;

    private String lecturerName;
}
