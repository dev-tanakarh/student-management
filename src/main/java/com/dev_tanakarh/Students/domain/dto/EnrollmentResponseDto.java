package com.dev_tanakarh.Students.domain.dto;

public record EnrollmentResponseDto(
        Long id,
        Long studentId,
        String studentName,
        Long courseId,
        String courseName
) {
}
