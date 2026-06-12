package org.example.eduEnrollment.services;


import org.example.eduEnrollment.dtos.requests.RegistrationRequest;
import org.example.eduEnrollment.dtos.responses.RegistrationResponse;

import java.util.List;

public interface RegistrationService {

    RegistrationResponse registerCourse(
            RegistrationRequest request
    );

    void dropCourse(
            String studentId,
            String courseId
    );

    List<RegistrationResponse> getStudentCourses(
            String studentId
    );

    void approveRegistration(String registrationId);

    void rejectRegistration(String registrationId);
}


