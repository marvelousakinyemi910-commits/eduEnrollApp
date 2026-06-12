package org.example.eduEnrollment.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LecturerResponse {

    private String id;

    private String fullName;

    private String email;

    private String department;
}
