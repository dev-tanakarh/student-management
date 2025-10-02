package com.dev_tanakarh.Students.domain.dto;

public record StudentDetatilsDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        List<CourseSummaryDto> enrolledCourses
) {
}
