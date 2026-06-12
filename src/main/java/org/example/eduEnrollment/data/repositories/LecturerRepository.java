package org.example.eduEnrollment.data.repositories;


import org.example.eduEnrollment.data.models.Lecturer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends MongoRepository<Lecturer, String> {
}