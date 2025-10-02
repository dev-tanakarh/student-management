package com.dev_tanakarh.Students.mappers.impl;

import com.dev_tanakarh.Students.domain.dto.CourseDto;
import com.dev_tanakarh.Students.domain.dto.CourseSummaryDto;
import com.dev_tanakarh.Students.domain.entities.Course;
import com.dev_tanakarh.Students.mappers.CourseMapper;

public class CourseMapperImpl implements CourseMapper {
    @Override
    public Course toEntity(CourseDto courseDto) {
        return Course.builder()
                .title(courseDto.title())
                .code(courseDto.code())
                .build();
    }

    @Override
    public CourseDto toCourseDto(Course course) {
        return new CourseDto(
                course.getTitle(),
                course.getCode());
    }

    @Override
    public CourseSummaryDto toSummaryDto(Course course) {
        return new CourseSummaryDto(
                course.getId(),
                course.getTitle(),
                course.getCode()
        );
    }
}
