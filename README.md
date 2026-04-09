# student-course-management-system
Java console application that manages students, courses, and enrollments using MySQL, including CRUD operations and enrollment functionality.

# Student Course Management System

This is a console-based Java application I built to manage students, courses, and enrollments using a MySQL database.

## What it does

* Add, view, update, and remove students
* Add and view courses
* Enroll students into courses
* View all enrollments (using a JOIN query)
* Search for students and courses

## How it’s built

I split the project into a few parts:

* **Models**: Student, Course, Enrollment
* **Services**: Handle all database operations
* **Main**: Handles user input and menu

The data is stored in MySQL and linked using IDs (student_id and course_id).

## Example

Jacques -> Math
Alex -> Science

## How to run it

1. Create a MySQL database called `university_db`

2. Run these tables:

```sql
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    student_number INT
);

CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100)
);

CREATE TABLE enrollments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT
);
```

3. Update your database details in `DatabaseConnection.java`

4. Run the `Main` class

## Notes

I built this to practice Java, working with databases, and understanding how different parts of a system connect together. It also helped me get more comfortable with SQL queries and using JDBC.
