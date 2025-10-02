package com.dev_tanakarh.Students.mappers;

import com.dev_tanakarh.Students.domain.dto.StudentDetatilsDto;
import com.dev_tanakarh.Students.domain.dto.StudentDto;
import com.dev_tanakarh.Students.domain.entities.Student;

public interface StudentMapper {
    Student toEntity(StudentDto studentDto);
    StudentDto toDto(Student student);
    StudentDetatilsDto toDetatilsDto(Student student);
}
