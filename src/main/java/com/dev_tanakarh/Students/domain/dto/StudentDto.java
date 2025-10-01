package com.dev_tanakarh.Students.domain.dto;

import com.dev_tanakarh.Students.domain.entities.Enrollment;

import java.util.List;

public record StudentDto(
        long id,
        String firstName,
        String lastName,
        String email
) {
}
