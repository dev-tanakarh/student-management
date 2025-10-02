package com.dev_tanakarh.Students.services;

import com.dev_tanakarh.Students.domain.dto.EnrollmentDto;
import com.dev_tanakarh.Students.domain.entities.Course;
import com.dev_tanakarh.Students.domain.entities.Enrollment;
import com.dev_tanakarh.Students.domain.entities.Student;

import java.util.List;

public interface EnrollmentService {
    Enrollment enrollStudent(EnrollmentDto enrollmentDto);
    List<Course> getCoursesForStudent(Long studentId);
    List<Student> getStudentsForCourse(Long courseId);
    void deleteEnrollment(Long id);
}
