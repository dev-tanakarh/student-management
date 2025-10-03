package com.dev_tanakarh.Students.controllers;
import com.dev_tanakarh.Students.domain.dto.ExamResultDetailsDto;
import com.dev_tanakarh.Students.domain.dto.ExamResultDto;
import com.dev_tanakarh.Students.domain.entities.ExamResult;
import com.dev_tanakarh.Students.services.ExamResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/exam-results")
public class ExamResultController {
    private final ExamResultService examResultService;

    //Create exam result
    @PostMapping
    public ResponseEntity<ExamResultDetailsDto> addExamResult(@RequestBody ExamResultDto examResultDto) {
        ExamResultDetailsDto createdResult = examResultService.addExamResult(examResultDto);
        return ResponseEntity.ok(createdResult);
    }

    //Update existing result
    @PutMapping("/{id}")
    public ResponseEntity<ExamResultDetailsDto> updateExamResult(
            @PathVariable Long id,
            @RequestBody ExamResultDto examResultDto
    ) {
        ExamResultDetailsDto updatedResult = examResultService.updateResult(id, examResultDto);
        return ResponseEntity.ok(updatedResult);
    }

    //Delete an exam result
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExamResult(@PathVariable Long id) {
        examResultService.deleteResult(id);
        return ResponseEntity.noContent().build();
    }

    //Get all results for a student
    @GetMapping("/student/{studentId}/results")
    public ResponseEntity<List<ExamResultDetailsDto>> getResultsForStudent(@PathVariable Long studentId) {
        List<ExamResultDetailsDto> results = examResultService.getResultsForStudent(studentId);
        return ResponseEntity.ok(results);
    }

    //Get all exam results for a course
    @GetMapping("/course/{courseId}/results")
    public ResponseEntity<List<ExamResultDetailsDto>> getResultsForCourse(@PathVariable Long courseId) {
        List<ExamResultDetailsDto> results = examResultService.getResultsForCourse(courseId);
        return ResponseEntity.ok(results);
    }
}
