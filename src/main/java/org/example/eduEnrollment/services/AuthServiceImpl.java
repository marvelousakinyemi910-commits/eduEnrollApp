package org.example.eduEnrollment.services;

import lombok.RequiredArgsConstructor;
import org.example.eduEnrollment.data.models.User;
import org.example.eduEnrollment.data.repositories.UserRepository;
import org.example.eduEnrollment.dtos.requests.LoginRequest;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Override
    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(
                        request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("Invalid email"));

        if (!user.getPassword()
                .equals(request.getPassword())) {

            throw new RuntimeException(
                    "Invalid password");
        }

        return "Login Successful";
    }
}
