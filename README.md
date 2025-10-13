
---

# 🎓 Student Management API

A **Spring Boot + PostgreSQL** RESTful API for managing students, courses, enrollments, and exam results.


---

## 🧭 Table of Contents

* [Overview](#overview)
* [Features](#features)
* [Tech Stack](#tech-stack)
* [Project Structure](#project-structure)
* [Setup Instructions](#setup-instructions)
* [API Endpoints](#api-endpoints)
* [Example Requests](#example-requests)
* [Author](#author)

---

## 📘 Overview

The **Student Management API** allows universities or institutions to:

* Manage student records
* Register courses
* Enroll students into courses
* Record and view exam results

This backend system follows **RESTful architecture** and demonstrates best practices for a clean, scalable API — perfect for showcasing Spring Boot and JPA skills.

---

## ✨ Features

✅ CRUD operations for Students, Courses, Enrollments, and Exam Results
✅ DTO-based architecture with ModelMapper
✅ PostgreSQL database integration
✅ Validation and error handling
✅ Layered architecture (Controller → Service → Repository → Entity)

---

## ⚙️ Tech Stack

| Layer         | Technology                         |
| ------------- | ---------------------------------- |
| Language      | **Java 21**                        |
| Framework     | **Spring Boot 3**                  |
| Database      | **PostgreSQL 17**                  |
| ORM           | **Spring Data JPA (Hibernate)**    |
| Build Tool    | **Maven**                          |

---

## 🧱 Project Structure

```
Students/
 ├── src/
 │   ├── main/
 │   │   ├── java/com/devtanaka/students/
 │   │   │   ├── config/          # OpenAPI configuration
 │   │   │   ├── controller/      # REST controllers
 │   │   │   ├── dto/             # Data Transfer Objects
 │   │   │   ├── entity/          # JPA entities
 │   │   │   ├── mapper/          # DTO ↔ Entity mappers
 │   │   │   ├── repository/      # JPA repositories
 │   │   │   ├── service/         # Business logic
 │   │   │   └── StudentsApplication.java
 │   │   └── resources/
 │   │       ├── application.properties
 │   │       └── data.sql / schema.sql (optional)
 ├── pom.xml
 └── README.md
```

---

## 🚀 Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/dev-tanakarh/student-management.git
cd Students
```

### 2️⃣ Configure PostgreSQL

Create a database:

```sql
CREATE DATABASE students_db;
```

Then update your `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/students_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
springdoc.api-docs.enabled=true
```

### 3️⃣ Build & Run the App

```bash
mvn clean install
mvn spring-boot:run
```

The app will start on **[http://localhost:8080](http://localhost:8080)**

---

## 🧩 API Endpoints

| Resource    | Method | Endpoint                                  | Description                  |
| ----------- | ------ | ----------------------------------------- | ---------------------------- |
| Student     | GET    | `/students`                               | Get all students             |
| Student     | POST   | `/students`                               | Add a new student            |
| Student     | GET    | `/students/{id}`                          | Get student by ID            |
| Student     | PUT    | `/students/{id}`                          | Update student               |
| Student     | DELETE | `/students/{id}`                          | Delete student               |
| Course      | GET    | `/courses`                                | Get all courses              |
| Course      | POST   | `/courses`                                | Add a new course             |
| Enrollment  | POST   | `/enrollments`                            | Enroll a student in a course |
| Enrollment  | GET    | `/enrollments/course/{courseId}/students` | Get students in a course     |
| Exam Result | POST   | `/exam-results`                           | Record a new exam result     |
| Exam Result | GET    | `/exam-results/student/{studentId}`       | Get results for a student    |

---


## 📬 Example Requests

**Add a Student**

```json
POST /students
{
  "firstName": "Tanaka",
  "lastName": "Hungwe",
  "email": "tanaka@example.com"
}
```

**Add a Course**

```json
POST /courses
{
  "name": "Software Engineering",
  "code": "SE101"
}
```

**Enroll Student**

```json
POST /enrollments
{
  "studentId": 1,
  "courseId": 2
}
```

**Add Exam Result**

```json
POST /exam-results
{
  "studentId": 1,
  "courseId": 2,
  "grade": "A"
}
```

---

## 🧑‍💻 Author

**👤 Tanaka Rodney Hungwe**
📍 Bachelor of Computer Science (ICT) – Eden University, Zambia
💼 Aspiring Software Engineer | Java + Spring Boot Developer
🌐 [GitHub Profile](https://github.com/dev-tanakarh)
📧 [tanaka@example.com](mailto:tanaka@tanakarh.dev@gmail.com)

---

## 🏆 License

This project is licensed under the **MIT License** — you are free to use, modify, and distribute with attribution.

---
