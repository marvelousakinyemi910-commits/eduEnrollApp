package org.example.eduEnrollment.services;

import lombok.RequiredArgsConstructor;
import org.example.eduEnrollment.data.models.Course;
import org.example.eduEnrollment.data.models.Lecturer;
import org.example.eduEnrollment.data.repositories.CourseRepository;
import org.example.eduEnrollment.data.repositories.LecturerRepository;
import org.example.eduEnrollment.dtos.requests.CourseRequest;
import org.example.eduEnrollment.dtos.responses.CourseResponse;
import org.example.eduEnrollment.utils.CourseMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final LecturerRepository lecturerRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseResponse createCourse(
            CourseRequest request) {

    Lecturer instructor =
              lecturerRepository.findById(
                                request.getLecturerId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Instructor not found"));

        Course course =
                courseMapper.toEntity(request);

        Course savedCourse =
                courseRepository.save(course);

        return courseMapper.toResponse(
                savedCourse,
                instructor.getFullName());
    }

    @Override
    public CourseResponse updateCourse(
            String courseId,
            CourseRequest request) {

        Course course =
                courseRepository.findById(courseId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Course not found"));

        course.setCourseCode(
                request.getCourseCode());

        course.setCourseName(
                request.getCourseName());

        course.setDescription(
                request.getDescription());

        course.setCredits(
                request.getCredits());

        course.setMaxStudents(
                request.getMaxStudents());

        course.setSchedule(
                request.getSchedule());

        Course updatedCourse =
                courseRepository.save(course);

       Lecturer lecturer =
               lecturerRepository.findById(
                                updatedCourse.getLecturerId())
                        .orElseThrow();

        return courseMapper.toResponse(
                updatedCourse,
               lecturer.getFullName());
    }

    @Override
    public List<CourseResponse> getAllCourses() {

        return courseRepository.findAll()
                .stream()
                .map(course -> {

                    Lecturer lecturer =
                            lecturerRepository
                                    .findById(
                                            course.getLecturerId())
                                    .orElse(null);

                    return courseMapper.toResponse(
                            course,
                          lecturer != null
                                    ? lecturer.getFullName()
                                    : "Not Assigned");
                })
                .toList();
    }

    @Override
    public void deleteCourse(
            String courseId) {

        courseRepository.deleteById(
                courseId);
    }
}
