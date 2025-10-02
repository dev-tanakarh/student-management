# Student Management API (IN PROGRESS)🚀

> 📌 A backend REST API for managing students, courses, enrollments, and exam results.  
> Built using Java, Spring Boot, and PostgreSQL.  
> *This project is currently under active development.*

---

## 📚 Description

The *Student Management API* is a Java-based backend system designed to simulate a university or college's student information system.

It allows management of:
- 🧑 Students
- 📘 Courses
- 📝 Enrollments (linking students to courses)
- 🎓 Exam Results

The project follows a clean layered architecture using *Spring Boot, with data persisted in **PostgreSQL* using *Spring Data JPA*.

---

## 🛠 Tech Stack

- *Language*: Java 17+
- *Framework*: Spring Boot
- *Database*: PostgreSQL
- *ORM*: Spring Data JPA / Hibernate
- *Testing*: Postman
- *IDE*: IntelliJ IDEA
- *Version Control*: Git + GitHub

---

## 🏗 Architecture

```text
Controller → Service → Repository → Database
           ↓
         DTOs (Request & Response Models)
