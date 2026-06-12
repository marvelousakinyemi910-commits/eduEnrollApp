package org.example.eduEnrollment.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.eduEnrollment.data.models.enums.Grade;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradeRequest {

    private String registrationId;

    private Grade grade;
    private String studentId;
    private String courseId;
}
