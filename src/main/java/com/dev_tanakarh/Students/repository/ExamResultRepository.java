package com.dev_tanakarh.Students.repository;

import com.dev_tanakarh.Students.domain.entities.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamResultRepository extends JpaRepository<ExamResult, Long> {
}
