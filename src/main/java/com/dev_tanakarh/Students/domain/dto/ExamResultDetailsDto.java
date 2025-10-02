package com.dev_tanakarh.Students.domain.dto;

public record ExamResultDetailsDto(
        Long id,
        Integer score,
        CourseSummaryDto courseSummaryDto
) {
}
