package com.dev_tanakarh.Students.domain.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title", nullable = false, unique = true)
    private String title;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @OneToMany(mappedBy = "student", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    List<Enrollment> enrollments;
}
