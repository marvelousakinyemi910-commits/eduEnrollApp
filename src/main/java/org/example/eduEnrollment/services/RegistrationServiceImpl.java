package org.example.eduEnrollment.services;

import lombok.RequiredArgsConstructor;
import org.example.eduEnrollment.data.models.Course;
import org.example.eduEnrollment.data.models.Registration;
import org.example.eduEnrollment.data.models.Student;
import org.example.eduEnrollment.data.models.enums.RegistrationStatus;
import org.example.eduEnrollment.data.repositories.CourseRepository;
import org.example.eduEnrollment.data.repositories.RegistrationRepository;
import org.example.eduEnrollment.data.repositories.StudentRepository;
import org.example.eduEnrollment.dtos.requests.RegistrationRequest;
import org.example.eduEnrollment.dtos.responses.RegistrationResponse;
import org.example.eduEnrollment.utils.RegistrationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final RegistrationMapper registrationMapper;

    @Override
    public RegistrationResponse registerCourse(
            RegistrationRequest request) {

        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() ->
                        new RuntimeException("Course not found"));

        Registration registration = Registration.builder()
                .student(student)
                .course(course)
                .status(RegistrationStatus.PENDING)
                .build();

        Registration savedRegistration =
                registrationRepository.save(registration);

        return registrationMapper.toResponse(savedRegistration);
    }

    @Override
    public void dropCourse(
            String studentId,
            String courseId) {

        Registration registration =
                registrationRepository
                        .findByStudentIdAndCourseId(studentId, courseId)
                        .orElseThrow(() ->
                                new RuntimeException("Registration not found"));

        registrationRepository.delete(registration);
    }

    @Override
    public List<RegistrationResponse> getStudentCourses(
            String studentId) {

        List<Registration> registrations =
                registrationRepository.findByStudentId(studentId);

        return registrations.stream()
                .map(registrationMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void approveRegistration(
            String registrationId) {

        Registration registration =
                registrationRepository.findById(registrationId)
                        .orElseThrow(() ->
                                new RuntimeException("Registration not found"));

        registration.setStatus(RegistrationStatus.APPROVED);

        registrationRepository.save(registration);
    }

    @Override
    public void rejectRegistration(
            String registrationId) {

        Registration registration =
                registrationRepository.findById(registrationId)
                        .orElseThrow(() ->
                                new RuntimeException("Registration not found"));

        registration.setStatus(RegistrationStatus.REJECTED);

        registrationRepository.save(registration);
    }
}