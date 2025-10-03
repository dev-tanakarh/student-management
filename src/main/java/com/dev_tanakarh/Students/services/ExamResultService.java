package com.dev_tanakarh.Students.services;

import com.dev_tanakarh.Students.domain.dto.ExamResultDetailsDto;
import com.dev_tanakarh.Students.domain.dto.ExamResultDto;
import com.dev_tanakarh.Students.domain.entities.ExamResult;

import java.util.List;

public interface ExamResultService {
    ExamResultDetailsDto addExamResult(ExamResultDto examResultDto);
    List<ExamResultDetailsDto> getResultsForStudent(Long studentId);
    List<ExamResultDetailsDto> getResultsForCourse(Long courseId);
    ExamResultDetailsDto updateResult(Long id, ExamResultDto dto);
    void deleteResult(Long id);
}
