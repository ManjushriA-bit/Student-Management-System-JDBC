# Student Management System using JDBC

A simple **Student Management System** developed in Java using **JDBC** and **MySQL**. This project demonstrates database connectivity and CRUD operations through a clean console-based application.

## Features

- Add a student
- View all students
- Search a student by ID
- Update student details
- Delete a student with confirmation
- Input validation for integer and CGPA values
- `PreparedStatement` for parameterized SQL queries
- Try-with-resources for automatic JDBC resource closing

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application logic |
| JDBC | Java-to-database connectivity |
| MySQL | Student data storage |
| Maven | Dependency management and build |

## Project Structure

```text
Student-Management-System-JDBC/
├── src/main/java/com/manjushri/sms/
│   ├── DBConnection.java
│   ├── Student.java
│   ├── StudentDAO.java
│   └── StudentManagementSystem.java
├── database/
│   └── student_management.sql
├── screenshots/
├── pom.xml
├── README.md
└── .gitignore
```

## Database Setup

1. Install and start MySQL Server.
2. Open MySQL Workbench or the MySQL command line.
3. Run `database/student_management.sql`.
4. The script creates the `student_management` database and `students` table and inserts optional sample records.

## Configure Database Password

Open:

`src/main/java/com/manjushri/sms/DBConnection.java`

Change:

```java
private static final String PASSWORD = "YOUR_MYSQL_PASSWORD";
```

to your local MySQL password. Do not commit a real password to GitHub.

If your MySQL username is not `root`, also change the `USER` value.

## Run with Maven

Make sure Java 17+ and Maven are installed.

From the project root:

```bash
mvn clean compile
mvn exec:java
```

## Run from an IDE

Open the project in IntelliJ IDEA, Eclipse, or VS Code, allow Maven to download dependencies, configure the database credentials, and run:

`StudentManagementSystem.java`

## Application Menu

```text
==============================================
       STUDENT MANAGEMENT SYSTEM - JDBC
==============================================

--------------- MENU ----------------
1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student
5. Delete Student
6. Exit
-------------------------------------
```

## JDBC Concepts Demonstrated

- `DriverManager.getConnection()` to establish a connection
- `Connection` for communication with MySQL
- `PreparedStatement` for executing parameterized SQL
- `ResultSet` for reading query results
- `executeUpdate()` for INSERT, UPDATE, and DELETE
- `executeQuery()` for SELECT operations
- Try-with-resources for safe resource management
- DAO pattern to keep database operations separate from the user interface

## CRUD Flow

```text
User
  ↓
StudentManagementSystem
  ↓
StudentDAO
  ↓
JDBC / PreparedStatement
  ↓
MySQL students table
```

## Sample Data

The SQL file contains three optional sample students so the View and Search operations can be tested immediately.

## Screenshots

Add screenshots of the running application in the `screenshots/` folder for the assignment submission. Suggested screenshots:

1. Main menu
2. Add student success
3. View all students
4. Search student
5. Update student success
6. Delete student success

## Academic Note

This project was created as a Module 3 assignment demonstrating a **Student Management System using JDBC**.
