package com.dev_tanakarh.Students.mappers;

import com.dev_tanakarh.Students.domain.dto.CourseDto;
import com.dev_tanakarh.Students.domain.entities.Course;

public interface CourseMapper {
    CourseDto mapToDto(Course course);
    Course mapFromDto(CourseDto courseDto);
}
