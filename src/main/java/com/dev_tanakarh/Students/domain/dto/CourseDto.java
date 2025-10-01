package com.dev_tanakarh.Students.domain.dto;

import java.util.List;

public record CourseDto(
        String title,
        String code,
        List<EnrollmentDto> enrollments
) {
}
