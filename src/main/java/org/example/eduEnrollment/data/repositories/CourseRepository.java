package org.example.eduEnrollment.data.repositories;

import org.example.eduEnrollment.data.models.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {

    Optional<Course> findByCourseCode(String courseCode);
}
