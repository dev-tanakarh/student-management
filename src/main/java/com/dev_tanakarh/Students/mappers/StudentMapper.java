package com.dev_tanakarh.Students.mappers;

import com.dev_tanakarh.Students.domain.dto.StudentDto;
import com.dev_tanakarh.Students.domain.entities.Student;

public interface StudentMapper {
    StudentDto mapToDto(Student student);
    Student mapFromDto(StudentDto studentDto);
}
