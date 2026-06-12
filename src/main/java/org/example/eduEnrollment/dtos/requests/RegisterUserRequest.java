package org.example.eduEnrollment.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.eduEnrollment.data.models.enums.UserRole;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterUserRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String role;
}