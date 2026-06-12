package org.example.eduEnrollment.data.repositories;

import org.example.eduEnrollment.data.models.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistrationRepository extends MongoRepository<Registration, String> {

    List<Registration> findByStudentId(String studentId);

    List<Registration> findByCourseId(String courseId);

    Optional<Registration> findByStudentIdAndCourseId(
            String studentId,
            String courseId
    );
}
