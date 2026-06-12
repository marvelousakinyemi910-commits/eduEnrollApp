package org.example.eduEnrollment.services;



import org.example.eduEnrollment.dtos.requests.RegisterUserRequest;
import org.example.eduEnrollment.dtos.responses.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse registerUser(
            RegisterUserRequest request);

    UserResponse getUserById(
            String userId);

    List<UserResponse> getAllUsers();

    void deleteUser(
            String userId);
}