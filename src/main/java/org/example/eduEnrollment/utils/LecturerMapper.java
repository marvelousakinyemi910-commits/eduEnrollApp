package org.example.eduEnrollment.utils;

import org.example.eduEnrollment.data.models.Lecturer;
import org.example.eduEnrollment.dtos.requests.LecturerRequest;
import org.example.eduEnrollment.dtos.responses.LecturerResponse;
import org.springframework.stereotype.Component;


@Component
public class LecturerMapper {

    public Lecturer toEntity(
           LecturerRequest request) {

        return Lecturer.builder()
                .fullName(
                        request.getFullName())
                .email(
                        request.getEmail())
                .department(
                        request.getDepartment())
                .build();
    }

    public LecturerResponse toResponse(Lecturer lecturer) {

        return LecturerResponse.builder()
                .id(lecturer.getId())
                .fullName(lecturer.getFullName())
                .email(lecturer.getEmail())
                .department(lecturer.getDepartment())
                .build();
    }
}