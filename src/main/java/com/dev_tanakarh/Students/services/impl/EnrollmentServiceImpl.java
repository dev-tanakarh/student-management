package com.dev_tanakarh.Students.services.impl;

import com.dev_tanakarh.Students.domain.dto.*;
import com.dev_tanakarh.Students.domain.entities.Course;
import com.dev_tanakarh.Students.domain.entities.Enrollment;
import com.dev_tanakarh.Students.domain.entities.Student;
import com.dev_tanakarh.Students.mappers.CourseMapper;
import com.dev_tanakarh.Students.mappers.EnrollmentMapper;
import com.dev_tanakarh.Students.mappers.StudentMapper;
import com.dev_tanakarh.Students.repository.CourseRepository;
import com.dev_tanakarh.Students.repository.EnrollmentRepository;
import com.dev_tanakarh.Students.repository.StudentRepository;
import com.dev_tanakarh.Students.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final EnrollmentMapper enrollmentMapper;
    private final CourseMapper courseMapper;
    private final StudentMapper studentMapper;

    @Override
    public Enrollment enrollStudent(EnrollmentDto enrollmentDto) {
        Student student = studentRepository.findById(enrollmentDto.studentId())
                .orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        Course course = courseRepository.findById(enrollmentDto.courseId())
                .orElseThrow(() -> new IllegalArgumentException("Course Not Found"));

        //Prevent duplicate enrollments
        if(enrollmentRepository.findByStudentAndCourse(student, course).isPresent()){
            throw new IllegalStateException("Student Already Exists");
        }

        Enrollment enrollment = enrollmentMapper.toEntity(enrollmentDto, student, course);
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<CourseSummaryDto> getCoursesForStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        return enrollmentRepository.findByStudent(student)
                .stream()
                .map(Enrollment::getCourse)
                .map(courseMapper::toSummaryDto)
                .toList();
    }

    @Override
    public List<StudentDto> getStudentsForCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course Not Found"));
        return enrollmentRepository.findByCourse(course)
                .stream()
                .map(Enrollment::getStudent)
                .map(studentMapper::toDto)
                .toList();
    }

    @Override
    public void deleteEnrollment(EnrollmentDto enrollmentDto) {
        Student student = studentRepository.findById(enrollmentDto.studentId())
                .orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        Course course = courseRepository.findById(enrollmentDto.courseId())
                .orElseThrow(() -> new IllegalArgumentException("Course Not Found"));
        Enrollment enrollment = enrollmentRepository.findByStudentAndCourse(student, course)
                .orElseThrow(() -> new IllegalArgumentException("Enrollment Not Found"));

        enrollmentRepository.delete(enrollment);
    }

    @Override
    public List<EnrollmentResponseDto> getAllEnrollments() {
        return enrollmentRepository.findAll().stream()
                .map(enrollment -> new EnrollmentResponseDto(
                        enrollment.getId(),
                        enrollment.getStudent().getId(),
                        enrollment.getStudent().getFirstName() + " " + enrollment.getStudent().getLastName(),
                        enrollment.getCourse().getId(),
                        enrollment.getCourse().getTitle()
                ))
                .toList();
    }
}
