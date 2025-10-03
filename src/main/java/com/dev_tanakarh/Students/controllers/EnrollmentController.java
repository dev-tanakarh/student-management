package com.dev_tanakarh.Students.controllers;

import com.dev_tanakarh.Students.domain.dto.*;
import com.dev_tanakarh.Students.domain.entities.Enrollment;
import com.dev_tanakarh.Students.services.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    //Enroll student in a course
    @PostMapping
    public ResponseEntity<String> enrollStudent(@RequestBody @Validated EnrollmentDto enrollmentDto){
        enrollmentService.enrollStudent(enrollmentDto);
        return ResponseEntity.ok("Student enrolled successfully");
    }

    //Unenroll a student from a course
    @DeleteMapping
    public ResponseEntity<String> unenroll(@RequestBody EnrollmentDto enrollmentDto){
        enrollmentService.deleteEnrollment(enrollmentDto);
        return ResponseEntity.ok("Student unenrolled successfully");
    }

    // Get all enrollments
    @GetMapping
    public ResponseEntity<List<EnrollmentResponseDto>> getAllEnrollments(){
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    //Get all courses a student is enrolled in
    @GetMapping("/student/{studentId}/courses")
    public ResponseEntity<List<CourseSummaryDto>> getCourseByStudent(@PathVariable Long studentId){
        return ResponseEntity.ok(enrollmentService.getCoursesForStudent(studentId));
    }

    //Get all students in a course
    @GetMapping("/course/{courseId}/students")
    public ResponseEntity<List<StudentDto>> getStudentDetailsByCourse(@PathVariable Long courseId){
        return ResponseEntity.ok(enrollmentService.getStudentsForCourse(courseId));
    }
}
