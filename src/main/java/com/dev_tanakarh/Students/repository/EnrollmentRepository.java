package com.dev_tanakarh.Students.repository;

import com.dev_tanakarh.Students.domain.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

}