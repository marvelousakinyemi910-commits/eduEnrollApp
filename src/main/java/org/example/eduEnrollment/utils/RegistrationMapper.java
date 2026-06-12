package org.example.eduEnrollment.utils;

import org.example.eduEnrollment.data.models.Registration;
import org.example.eduEnrollment.data.models.enums.RegistrationStatus;
import org.example.eduEnrollment.dtos.requests.RegistrationRequest;
import org.example.eduEnrollment.dtos.responses.RegistrationResponse;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class RegistrationMapper {

    public Registration toEntity(
            RegistrationRequest request) {

        return Registration.builder()
                .studentId(request.getStudentId())
                .courseId(request.getCourseId())
                .status(
                        RegistrationStatus.APPROVED)
                .registrationDate(
                        LocalDateTime.now())
                .build();
    }

    public RegistrationResponse toResponse(
            Registration registration) {

        return RegistrationResponse.builder()
                .registrationId(
                        registration.getId())
                .studentId(
                        registration.getStudentId())
                .courseId(
                        registration.getCourseId())
                .status(
                        registration.getStatus())
                .grade(
                        registration.getGrade())
                .build();
    }
}