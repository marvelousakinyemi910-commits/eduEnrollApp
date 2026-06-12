package org.example.eduEnrollment.services;




import org.example.eduEnrollment.dtos.requests.GradeRequest;
import org.example.eduEnrollment.dtos.responses.TranscriptResponse;

import java.util.List;

public interface GradeService {

    void assignGrade(
            GradeRequest request
    );

    List<TranscriptResponse> getTranscript(
            String studentId
    );
}