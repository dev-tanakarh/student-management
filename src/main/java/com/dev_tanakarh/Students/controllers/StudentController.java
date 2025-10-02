package com.dev_tanakarh.Students.controllers;

import com.dev_tanakarh.Students.domain.dto.StudentDetatilsDto;
import com.dev_tanakarh.Students.domain.dto.StudentDto;
import com.dev_tanakarh.Students.domain.entities.Student;
import com.dev_tanakarh.Students.mappers.StudentMapper;
import com.dev_tanakarh.Students.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    //Create student
    @PostMapping
    public ResponseEntity<StudentDetatilsDto> createStudent(@RequestBody @Validated StudentDto studentDto) {
        Student saved = studentService.createStudent(studentDto);
        StudentDetatilsDto response = studentMapper.toDetatilsDto(saved);
        return new  ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //Get all students
    @GetMapping
    public List<StudentDetatilsDto> getAllStudents() {
        return studentService.getAllStudents()
                .stream()
                .map(studentMapper::toDetatilsDto)
                .toList();
    }

    //Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentDetatilsDto> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(studentMapper.toDetatilsDto(student));
    }

    //Update student
    @PutMapping("/{id}")
    public ResponseEntity<StudentDetatilsDto> updateStudent(
            @PathVariable Long id,
            @RequestBody @Validated StudentDto studentDto
    ) {
        Student updated = studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok(studentMapper.toDetatilsDto(updated));
    }

    //Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
}
