package org.example.eduEnrollment.dtos.responses;

import lombok.Builder;
import lombok.Data;
import org.example.eduEnrollment.data.models.enums.Grade;
import org.example.eduEnrollment.data.models.enums.RegistrationStatus;


@Data
@Builder
public class RegistrationResponse {
    private String registrationId;

    private String studentId;

    private String courseId;

    private RegistrationStatus status;

    private Grade grade;
}
