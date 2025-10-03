package com.dev_tanakarh.Students.mappers.impl;

import com.dev_tanakarh.Students.domain.dto.ExamResultDetailsDto;
import com.dev_tanakarh.Students.domain.dto.ExamResultDto;
import com.dev_tanakarh.Students.domain.entities.Course;
import com.dev_tanakarh.Students.domain.entities.ExamResult;
import com.dev_tanakarh.Students.domain.entities.Student;
import com.dev_tanakarh.Students.mappers.ExamResultMapper;
import org.springframework.stereotype.Component;

@Component
public class ExamResultMapperImpl implements ExamResultMapper {
    @Override
    public ExamResult toEntity(ExamResultDto examResultDto, Student student, Course course) {
        return ExamResult.builder()
                .student(student)
                .course(course)
                .grade(examResultDto.grade())
                .build();
    }

    @Override
    public ExamResultDetailsDto toDetailsDto(ExamResult examResult) {
        return new ExamResultDetailsDto(
                examResult.getId(),
                examResult.getStudent().getId(),
                examResult.getStudent().getFirstName() + " " + examResult.getStudent().getLastName(),
                examResult.getCourse().getId(),
                examResult.getCourse().getTitle(),
                examResult.getGrade()
        );
    }
}
