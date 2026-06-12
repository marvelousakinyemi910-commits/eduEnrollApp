package org.example.eduEnrollment.services;

import lombok.RequiredArgsConstructor;
import org.example.eduEnrollment.data.models.Course;
import org.example.eduEnrollment.data.models.Registration;
import org.example.eduEnrollment.data.repositories.CourseRepository;
import org.example.eduEnrollment.data.repositories.RegistrationRepository;
import org.example.eduEnrollment.dtos.requests.GradeRequest;
import org.example.eduEnrollment.dtos.responses.TranscriptResponse;
import org.example.eduEnrollment.utils.TranscriptMapper;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService {

    private final RegistrationRepository
            registrationRepository;

    private final CourseRepository
            courseRepository;

    private final TranscriptMapper
            transcriptMapper;

    @Override
    public void assignGrade(
            GradeRequest request) {

        Registration registration =
                registrationRepository
                        .findByStudentIdAndCourseId(
                                request.getStudentId(),
                                request.getCourseId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Registration not found"));

        registration.setGrade(
                request.getGrade());

        registrationRepository.save(
                registration);
    }

    @Override
    public List<TranscriptResponse>
    getTranscript(String studentId) {

        List<Registration> registrations =
                registrationRepository
                        .findByStudentId(studentId);

        return registrations.stream()
                .map(registration -> {

                    Course course =
                            courseRepository.findById(
                                            registration.getCourseId())
                                    .orElseThrow();

                    return transcriptMapper
                            .toResponse(registration,
                                    course);
                })
                .toList();
    }
}
