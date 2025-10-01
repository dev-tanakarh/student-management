package com.dev_tanakarh.Students.mappers;

import com.dev_tanakarh.Students.domain.dto.EnrollmentDto;
import com.dev_tanakarh.Students.domain.entities.Enrollment;

public interface EnrollmentMapper {
    EnrollmentDto mapToDto(Enrollment enrollment);

    Enrollment mapFromDto(EnrollmentDto enrollmentDto);
}
