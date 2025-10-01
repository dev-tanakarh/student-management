package com.dev_tanakarh.Students.mappers.impl;

import com.dev_tanakarh.Students.domain.dto.StudentDto;
import com.dev_tanakarh.Students.domain.entities.Student;
import com.dev_tanakarh.Students.mappers.EnrollmentMapper;
import com.dev_tanakarh.Students.mappers.StudentMapper;

import java.util.List;
import java.util.Optional;

public class StudentMapperImpl implements StudentMapper {
    @Override
    public StudentDto mapToDto(Student student) {
        StudentDto studentDto;
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    @Override
    public Student mapFromDto(StudentDto studentDto) {
        return new Student(
                studentDto.firstName(),
                studentDto.lastName(),
                studentDto.email()
        );
    }
}
