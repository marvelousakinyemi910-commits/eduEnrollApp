package org.example.eduEnrollment.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.eduEnrollment.data.models.enums.Grade;
import org.example.eduEnrollment.data.models.enums.RegistrationStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;

@Document(collection = "registrations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Registration {

    @Id
    private String id;

     private Course course;

     private String courseId;

     private String studentId;

    private RegistrationStatus status;

    private Grade grade;

    private Student student;

    private LocalDateTime registrationDate;
}