package com.dev_tanakarh.Students.services;

import com.dev_tanakarh.Students.domain.dto.*;
import com.dev_tanakarh.Students.domain.entities.Course;
import com.dev_tanakarh.Students.domain.entities.Enrollment;
import com.dev_tanakarh.Students.domain.entities.Student;

import java.util.List;

public interface EnrollmentService {
    Enrollment enrollStudent(EnrollmentDto enrollmentDto);
    List<CourseSummaryDto> getCoursesForStudent(Long studentId);
    List<StudentDto> getStudentsForCourse(Long courseId);
    void deleteEnrollment(EnrollmentDto enrollmentDto);
    List<EnrollmentResponseDto> getAllEnrollments();
}
