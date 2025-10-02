package com.dev_tanakarh.Students.services.impl;

import com.dev_tanakarh.Students.domain.dto.ExamResultDto;
import com.dev_tanakarh.Students.domain.entities.Course;
import com.dev_tanakarh.Students.domain.entities.ExamResult;
import com.dev_tanakarh.Students.domain.entities.Student;
import com.dev_tanakarh.Students.mappers.ExamResultMapper;
import com.dev_tanakarh.Students.repository.CourseRepository;
import com.dev_tanakarh.Students.repository.ExamResultRepository;
import com.dev_tanakarh.Students.repository.StudentRepository;
import com.dev_tanakarh.Students.services.ExamResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamResultServiceImpl implements ExamResultService {

    private final ExamResultRepository examResultRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ExamResultMapper examResultMapper;

    @Override
    public ExamResult addExamResult(ExamResultDto examResultDto) {
        Student student = studentRepository.findById(examResultDto.studentId())
                .orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        Course course = courseRepository.findById(examResultDto.courseId())
                .orElseThrow(() -> new IllegalArgumentException("Course Not Found"));
        ExamResult examResult = examResultMapper.toEntity(examResultDto, student, course);

        return examResultRepository.save(examResult);
    }

    @Override
    public List<ExamResult> getResultsForStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).
                orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        return examResultRepository.findByStudent(student);
    }

    @Override
    public List<ExamResult> getResultsForCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).
                orElseThrow(() -> new IllegalArgumentException("Course Not Found"));
        return examResultRepository.findByCourse(course);
    }

    @Override
    public ExamResult updateResult(Long id, ExamResultDto dto) {
        ExamResult existing = examResultRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Exam Result Not Found"));
        Student student = studentRepository.findById(dto.studentId())
                .orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        Course course = courseRepository.findById(dto.courseId())
                .orElseThrow(() -> new IllegalArgumentException("Course Not Found"));

        existing.setStudent(student);
        existing.setCourse(course);
        existing.setGrade(dto.grade());
        return examResultRepository.save(existing);
    }

    @Override
    public void deleteResult(Long id) {
        ExamResult examResult = examResultRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Exam Result Not Found"));
        examResultRepository.delete(examResult);
    }
}
