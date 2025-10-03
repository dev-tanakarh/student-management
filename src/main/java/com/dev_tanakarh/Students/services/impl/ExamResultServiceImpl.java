package com.dev_tanakarh.Students.services.impl;

import com.dev_tanakarh.Students.domain.dto.ExamResultDetailsDto;
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
    public ExamResultDetailsDto addExamResult(ExamResultDto examResultDto) {
        // Find the student by ID from the DTO
        Student student = studentRepository.findById(examResultDto.studentId())
                .orElseThrow(() -> new IllegalArgumentException("Student Not Found"));

        // Find the course by ID from the DTO
        Course course = courseRepository.findById(examResultDto.courseId())
                .orElseThrow(() -> new IllegalArgumentException("Course Not Found"));

        // Map the DTO to an ExamResult entity
        ExamResult examResult = examResultMapper.toEntity(examResultDto, student, course);

        // Save the ExamResult entity to the database
        ExamResult createdExamResult = examResultRepository.save(examResult);

        // Map the saved entity to a detailed DTO and return it
        return examResultMapper.toDetailsDto(createdExamResult);
    }


    @Override
    public List<ExamResultDetailsDto> getResultsForStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).
                orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        return examResultRepository.findByStudent(student)
                .stream()
                .map(examResultMapper::toDetailsDto)
                .toList();
    }

    @Override
    public List<ExamResultDetailsDto> getResultsForCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).
                orElseThrow(() -> new IllegalArgumentException("Course Not Found"));
        return examResultRepository.findByCourse(course)
                .stream()
                .map(examResultMapper::toDetailsDto)
                .toList();
    }

    @Override
    public ExamResultDetailsDto updateResult(Long id, ExamResultDto dto) {
        ExamResult existing = examResultRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Exam Result Not Found"));
        Student student = studentRepository.findById(dto.studentId())
                .orElseThrow(() -> new IllegalArgumentException("Student Not Found"));
        Course course = courseRepository.findById(dto.courseId())
                .orElseThrow(() -> new IllegalArgumentException("Course Not Found"));

        existing.setStudent(student);
        existing.setCourse(course);
        existing.setGrade(dto.grade());

        ExamResult updated = examResultRepository.save(existing);
        return examResultMapper.toDetailsDto(updated);  // <-- convert to DTO here
    }


    @Override
    public void deleteResult(Long id) {
        ExamResult examResult = examResultRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Exam Result Not Found"));
        examResultRepository.delete(examResult);
    }
}
