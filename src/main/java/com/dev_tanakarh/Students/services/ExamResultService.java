package com.dev_tanakarh.Students.services;

import com.dev_tanakarh.Students.domain.dto.ExamResultDto;
import com.dev_tanakarh.Students.domain.entities.ExamResult;

import java.util.List;

public interface ExamResultService {
    ExamResult addExamResult(ExamResultDto examResultDto);
    List<ExamResult> getResultsForStudent(Long studentId);
    List<ExamResult> getResultsForCourse(Long courseId);
    ExamResult updateResult(Long id, ExamResultDto dto);
    void deleteResult(Long id);
}
