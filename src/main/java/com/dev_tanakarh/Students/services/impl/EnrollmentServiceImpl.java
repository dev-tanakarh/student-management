package com.dev_tanakarh.Students.services.impl;

import com.dev_tanakarh.Students.domain.dto.EnrollmentDto;
import com.dev_tanakarh.Students.domain.entities.Course;
import com.dev_tanakarh.Students.domain.entities.Enrollment;
import com.dev_tanakarh.Students.domain.entities.Student;
import com.dev_tanakarh.Students.mappers.EnrollmentMapper;
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

    EnrollmentRepository enrollmentRepository;
    CourseRepository courseRepository;
    StudentRepository studentRepository;
    EnrollmentMapper enrollmentMapper;

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
    public List<Course> getCoursesForStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        return enrollmentRepository.findByStudent(student)
                .stream()
                .map(Enrollment::getCourse)
                .toList();
    }

    @Override
    public List<Student> getStudentsForCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course Not Found"));
        return enrollmentRepository.findByCourse(course)
                .stream()
                .map(Enrollment::getStudent)
                .toList();
    }

    @Override
    public void deleteEnrollment(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course Not Found"));
        Enrollment enrollment = enrollmentRepository.findByStudentAndCourse(student, course)
                .orElseThrow(() -> new IllegalArgumentException("Enrollment Not Found"));

        enrollmentRepository.delete(enrollment);
    }
}
