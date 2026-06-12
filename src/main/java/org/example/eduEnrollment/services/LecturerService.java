package org.example.eduEnrollment.services;


import org.example.eduEnrollment.dtos.requests.LecturerRequest;
import org.example.eduEnrollment.dtos.responses.LecturerResponse;

import java.util.List;

public interface LecturerService {

    LecturerResponse createLecturer(
            LecturerRequest request);

    public List<LecturerResponse> getAllLecturers();

    void deleteLecturer(
            String lecturerId);
}