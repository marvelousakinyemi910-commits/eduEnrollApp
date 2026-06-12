package org.example.eduEnrollment.utils;

import org.example.eduEnrollment.data.models.User;
import org.example.eduEnrollment.data.models.enums.UserRole;
import org.example.eduEnrollment.dtos.requests.RegisterUserRequest;
import org.example.eduEnrollment.dtos.responses.UserResponse;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    public User toEntity(RegisterUserRequest request) {
        User user = new  User();

        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setPassword(request.getPassword());
        user.setLastName(request.getLastName());
        user.setRole(UserRole.valueOf(request.getRole()));

        return user;

    }

    public UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setRole(user.getRole());

        return userResponse;

    }
}
