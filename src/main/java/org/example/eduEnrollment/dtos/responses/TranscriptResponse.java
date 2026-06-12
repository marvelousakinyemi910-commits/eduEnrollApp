package org.example.eduEnrollment.dtos.responses;


import lombok.Builder;
import lombok.Data;
import org.example.eduEnrollment.data.models.enums.Grade;

@Data
    @Builder
    public class TranscriptResponse {

        private String courseCode;

        private String courseName;

        private Grade grade;

        private Integer credits;
    }

