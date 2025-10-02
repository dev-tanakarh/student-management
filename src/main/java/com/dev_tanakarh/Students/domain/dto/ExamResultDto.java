package com.dev_tanakarh.Students.domain.dto;

public record ExamResultDto(
    Long studentId,
    Long courseId,
    Integer grade
) {
}
