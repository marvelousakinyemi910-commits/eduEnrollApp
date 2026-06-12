package org.example.eduEnrollment.data.repositories;

import org.example.eduEnrollment.data.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    Optional<Student> findByMatricNumber(String matricNumber);
}