package org.example.eduEnrollment.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentRequest {

    private String matricNumber;

    private String department;

    private String level;

    private String userId;
}
