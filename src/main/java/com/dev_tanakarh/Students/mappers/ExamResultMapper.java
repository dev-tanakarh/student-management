package com.dev_tanakarh.Students.mappers;

import com.dev_tanakarh.Students.domain.dto.ExamResultDetailsDto;
import com.dev_tanakarh.Students.domain.dto.ExamResultDto;
import com.dev_tanakarh.Students.domain.entities.Course;
import com.dev_tanakarh.Students.domain.entities.ExamResult;
import com.dev_tanakarh.Students.domain.entities.Student;

public interface ExamResultMapper {
    ExamResult toEntity(ExamResultDto examResultDto, Student student, Course course);
    ExamResultDetailsDto toDetailsDto(ExamResult examResult);
}
