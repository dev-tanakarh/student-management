package com.dev_tanakarh.Students.domain.dto;

public record ExamResultDto(
        int studentId,
        int courseId,
        int grade
) {
}
