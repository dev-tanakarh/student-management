package com.dev_tanakarh.Students.repository;

import com.dev_tanakarh.Students.domain.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
