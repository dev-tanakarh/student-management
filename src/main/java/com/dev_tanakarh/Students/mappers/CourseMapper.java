package com.dev_tanakarh.Students.mappers;

import com.dev_tanakarh.Students.domain.dto.CourseDto;
import com.dev_tanakarh.Students.domain.dto.CourseSummaryDto;
import com.dev_tanakarh.Students.domain.entities.Course;

public interface CourseMapper {
    Course toEntity(CourseDto courseDto);
    CourseDto toCourseDto(Course course);
    CourseSummaryDto toSummaryDto(Course course);

}
