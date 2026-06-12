package org.example.eduEnrollment.services;

import lombok.RequiredArgsConstructor;
import org.example.eduEnrollment.data.models.Lecturer;
import org.example.eduEnrollment.data.repositories.LecturerRepository;
import org.example.eduEnrollment.dtos.requests.LecturerRequest;
import org.example.eduEnrollment.dtos.responses.LecturerResponse;
import org.example.eduEnrollment.utils.LecturerMapper;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;
    private final LecturerMapper lecturerMapper;

    @Override
    public LecturerResponse createLecturer(LecturerRequest request) {

        Lecturer lecturer = lecturerMapper.toEntity(request);

        Lecturer savedLecturer = lecturerRepository.save(lecturer);

        return lecturerMapper.toResponse(savedLecturer);
    }

    @Override
    public List<LecturerResponse> getAllLecturers() {

        return lecturerRepository.findAll()
                .stream()
                .map(lecturerMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteLecturer(String lecturerId) {

        Lecturer lecturer = lecturerRepository.findById(lecturerId)
                .orElseThrow(() ->
                        new RuntimeException("Lecturer not found"));

        lecturerRepository.delete(lecturer);
    }
}