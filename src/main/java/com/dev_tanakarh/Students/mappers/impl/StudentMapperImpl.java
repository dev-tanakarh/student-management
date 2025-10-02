package com.dev_tanakarh.Students.mappers.impl;

import com.dev_tanakarh.Students.domain.dto.StudentDetatilsDto;
import com.dev_tanakarh.Students.domain.dto.StudentDto;
import com.dev_tanakarh.Students.domain.entities.Student;
import com.dev_tanakarh.Students.mappers.StudentMapper;

import java.util.stream.Collectors;

public class StudentMapperImpl implements StudentMapper {
    @Override
    public Student toEntity(StudentDto studentDto) {
        return Student.builder()
                .firstName(studentDto.firstName())
                .lastName(studentDto.lastName())
                .email(studentDto.email())
                .build();
    }

    @Override
    public StudentDto toDto(Student student) {
        return new StudentDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    @Override
    public StudentDetatilsDto toDetatilsDto(Student student) {
        return new StudentDetatilsDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getEnrollments().stream()
                        .map(enrollment -> CourseMapper.toSummaryDto(enrollment.getCourse()))
                        .collect(Collectors.toList())
        );
    }
}
