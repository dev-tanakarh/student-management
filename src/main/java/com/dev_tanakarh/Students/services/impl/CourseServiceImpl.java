package com.dev_tanakarh.Students.services.impl;

import com.dev_tanakarh.Students.domain.dto.CourseDto;
import com.dev_tanakarh.Students.domain.entities.Course;
import com.dev_tanakarh.Students.mappers.CourseMapper;
import com.dev_tanakarh.Students.repository.CourseRepository;
import com.dev_tanakarh.Students.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public Course createCourse(CourseDto courseDto) {
        return courseRepository.save(courseMapper.toEntity(courseDto));
    }

    @Override
    public Course updateCourse(Long id, CourseDto courseDto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course with id " + id + " not found"));
        course.setTitle(courseDto.title());
        course.setCode(courseDto.code());
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new IllegalCallerException("Course not found"));
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourseById(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new IllegalArgumentException("Course with id " + id + " not found");
        }
        courseRepository.deleteById(id);
    }
}
