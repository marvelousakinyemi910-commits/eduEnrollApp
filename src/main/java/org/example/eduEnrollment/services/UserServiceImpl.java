package org.example.eduEnrollment.services;


import lombok.RequiredArgsConstructor;
import org.example.eduEnrollment.data.models.User;
import org.example.eduEnrollment.data.repositories.UserRepository;
import org.example.eduEnrollment.dtos.requests.RegisterUserRequest;
import org.example.eduEnrollment.dtos.responses.UserResponse;
import org.example.eduEnrollment.utils.UserMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl
        implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse registerUser(
            RegisterUserRequest request) {

        Optional<User> existingUser =
                userRepository.findByEmail(
                        request.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException(
                    "Email already exists");
        }

        User user =
                userMapper.toEntity(request);

        User savedUser =
                userRepository.save(user);

        return userMapper.toResponse(
                savedUser);
    }

    @Override
    public UserResponse getUserById(
            String userId) {

        User user =
                userRepository.findById(userId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User not found"));

        return userMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteUser(
            String userId) {

        User user =
                userRepository.findById(userId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "User not found"));

        userRepository.delete(user);
    }
}