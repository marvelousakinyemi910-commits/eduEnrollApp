package org.example.eduEnrollment.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@NoArgsConstructor

@AllArgsConstructor
@Builder
@Data
public class Course {
    @Id
    private String id;

    private String courseName;

    private String  lecturerId;

    private String courseCode;

    private String description;

    private Integer credits;

    private Integer maxStudents;

    private Integer registeredStudents;

    private String schedule;

}
