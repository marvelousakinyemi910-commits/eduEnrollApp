package org.example.eduEnrollment.services;


import org.example.eduEnrollment.dtos.requests.LoginRequest;

public interface AuthService {

    String login(LoginRequest request);
}
