package com.dev_tanakarh.Students.mappers;

import com.dev_tanakarh.Students.domain.dto.ExamResultDto;
import com.dev_tanakarh.Students.domain.entities.ExamResult;

public interface ExamResultMapper {
    ExamResultDto mapToDto(ExamResult examResult);
    ExamResult mapFromDto(ExamResultDto examResultDto);
}
