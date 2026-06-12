Educational Management System API

An Educational Management System built with Spring Boot that enables administrators, instructors, and students to manage courses, enrollments, assessments, and academic records through a scalable RESTful API.

Features
Student registration and authentication
Instructor management
Course creation and management
Student course enrollment
Assignment creation and submission
Quiz and assessment management
Grade recording and tracking
Student academic performance monitoring
Course catalog management
DTO-based request and response handling
RESTful API architecture
Exception handling and validation
Role-based system design
Maven project structure
Technologies Used
Java
Spring Boot
Spring Data JPA
Maven
MySQL
Lombok
REST APIs
Architecture

The application follows a layered architecture:

Controller Layer – Handles API requests and responses.
Service Layer – Contains business logic for students, instructors, courses, and assessments.
Repository Layer – Manages database operations using JPA.
Model Layer – Represents entities such as Students, Instructors, Courses, Enrollments, and Assignments.
DTO Layer – Facilitates data transfer between the client and server while maintaining clean architecture principles.
Core Workflow
Students create accounts and log in.
Instructors create and manage courses.
Students browse available courses and enroll.
Instructors publish assignments and assessments.
Students submit assignments through the platform.
Instructors evaluate submissions and assign grades.
Students track their academic progress and performance.
Administrators oversee users, courses, and academic records.
Key Entities
Student
Student ID
Full Name
Email
Password
Enrolled Courses
Instructor
Instructor ID
Full Name
Email
Courses Taught
Course
Course ID
Course Title
Description
Instructor
Enrollment
Student
Course
Enrollment Date
Status
Assignment
Assignment Title
Description
Due Date
Submission Status
Grade
Student
Course
Score
Feedback
