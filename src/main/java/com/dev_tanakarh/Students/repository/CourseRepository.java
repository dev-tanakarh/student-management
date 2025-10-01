package com.dev_tanakarh.Students.repository;

import com.dev_tanakarh.Students.domain.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
