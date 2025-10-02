package com.dev_tanakarh.Students.services;

import com.dev_tanakarh.Students.domain.dto.StudentDto;
import com.dev_tanakarh.Students.domain.entities.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentDto studentDto);
    Student updateStudent(Long id, StudentDto studentDto);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    void deleteStudentById(Long id);
}
