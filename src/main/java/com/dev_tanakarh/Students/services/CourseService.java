package com.dev_tanakarh.Students.services;

import com.dev_tanakarh.Students.domain.dto.CourseDto;
import com.dev_tanakarh.Students.domain.entities.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(CourseDto courseDto);
    Course updateCourse(Long id, CourseDto courseDto);
    Course getCourseById(Long id);
    List<Course> getAllCourses();
    void deleteCourseById(Long id);
}
