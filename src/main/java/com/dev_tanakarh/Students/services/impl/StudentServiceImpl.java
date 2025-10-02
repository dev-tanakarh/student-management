package com.dev_tanakarh.Students.services.impl;

import com.dev_tanakarh.Students.domain.dto.StudentDto;
import com.dev_tanakarh.Students.domain.entities.Student;
import com.dev_tanakarh.Students.mappers.StudentMapper;
import com.dev_tanakarh.Students.repository.StudentRepository;
import com.dev_tanakarh.Students.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public Student createStudent(StudentDto studentDto) {
        Optional<Student> existing = studentRepository.findByEmail(studentDto.email());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Student with email " + studentDto.email() + " already exists");
        }
        return studentRepository.save(studentMapper.toEntity(studentDto));
    }

    @Override
    public Student updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with id " + id + " not found"));
        student.setFirstName(studentDto.firstName());
        student.setLastName(studentDto.lastName());
        student.setEmail(studentDto.email());
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with id " + id + " not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalArgumentException("Student with id " + id + " not found");
        }
        studentRepository.deleteById(id);
    }
}
