package org.example.eduEnrollment.controllers;


import lombok.RequiredArgsConstructor;
import org.example.eduEnrollment.dtos.requests.RegisterUserRequest;
import org.example.eduEnrollment.dtos.responses.UserResponse;
import org.example.eduEnrollment.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register-user")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterUserRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.registerUser(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String id) {

        return ResponseEntity.ok(
                userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {

        return ResponseEntity.ok(
                userService.getAllUsers());
    }
}
