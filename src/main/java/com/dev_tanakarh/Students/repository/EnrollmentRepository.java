package com.dev_tanakarh.Students.repository;

import com.dev_tanakarh.Students.domain.entities.Course;
import com.dev_tanakarh.Students.domain.entities.Enrollment;
import com.dev_tanakarh.Students.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudent(Student student); //return all student enrollments
    List<Enrollment> findByCourse(Course course); //return all course enrollments
    List<Enrollment> findByStudentAndCourse(Student student, Course course); //Return all enrollments of a student and course
}