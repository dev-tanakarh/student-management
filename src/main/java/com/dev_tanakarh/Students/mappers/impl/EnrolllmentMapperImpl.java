package com.dev_tanakarh.Students.mappers.impl;

import com.dev_tanakarh.Students.domain.dto.EnrollmentDto;
import com.dev_tanakarh.Students.domain.entities.Course;
import com.dev_tanakarh.Students.domain.entities.Enrollment;
import com.dev_tanakarh.Students.domain.entities.Student;
import com.dev_tanakarh.Students.mappers.EnrollmentMapper;

public class EnrolllmentMapperImpl implements EnrollmentMapper {
    @Override
    public Enrollment toEntity(EnrollmentDto enrollmentDto, Student student, Course course) {
        return Enrollment.builder()
                .student(student)
                .course(course)
                .build();
    }
}
