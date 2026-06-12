package org.example.eduEnrollment.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "instructors")

@NoArgsConstructor
@AllArgsConstructor
@Builder

@Data
public class Lecturer {
    @Id
    private String id;

    private String fullName;

    private String email;

    private String department;
}