package com.dev_tanakarh.Students.controllers;

import com.dev_tanakarh.Students.domain.dto.CourseDto;
import com.dev_tanakarh.Students.domain.dto.CourseSummaryDto;
import com.dev_tanakarh.Students.domain.entities.Course;
import com.dev_tanakarh.Students.mappers.CourseMapper;
import com.dev_tanakarh.Students.services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
@Tag(name = "Course", description = "Endpoint for managing courses")
public class CourseController {
    private final CourseService courseService;
    private final CourseMapper courseMapper;


    //Create course
    @PostMapping
    @Operation(summary = "Create new course")
    public ResponseEntity<CourseSummaryDto> createCourse(
            @RequestBody @Validated CourseDto courseDto
    ) {
        Course course = courseService.createCourse(courseDto);
        return new ResponseEntity<>(courseMapper.toSummaryDto(course), HttpStatus.OK);
    }

    //Get ALl Courses
    @GetMapping
    public ResponseEntity<List<CourseSummaryDto>> getAllCourses() {
        List<CourseSummaryDto> list = courseService.getAllCourses()
                .stream()
                .map(courseMapper::toSummaryDto)
                .toList();
        return ResponseEntity.ok(list);
    }

    //Get course by ID
    @GetMapping("/{id}")
    public ResponseEntity<CourseSummaryDto> getCourseById(@PathVariable Long id){
        Course course = courseService.getCourseById(id);
        return ResponseEntity.ok(courseMapper.toSummaryDto(course));
    }

    //Update course
    @PutMapping("/{id}")
    public ResponseEntity<CourseSummaryDto> updateCourse(
            @PathVariable Long id,
            @RequestBody @Validated CourseDto courseDto
    ){
        Course course = courseService.updateCourse(id, courseDto);
        return ResponseEntity.ok(courseMapper.toSummaryDto(course));
    }

    //Delete course
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        courseService.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }
}
