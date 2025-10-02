package com.dev_tanakarh.Students.mappers;

import com.dev_tanakarh.Students.domain.dto.EnrollmentDto;
import com.dev_tanakarh.Students.domain.entities.Course;
import com.dev_tanakarh.Students.domain.entities.Enrollment;
import com.dev_tanakarh.Students.domain.entities.Student;

public interface EnrollmentMapper {
    Enrollment toEntity(EnrollmentDto enrollmentDto, Student student,  Course course);
}
