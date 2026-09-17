CREATE DATABASE IF NOT EXISTS student_management;
USE student_management;

CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    department VARCHAR(100) NOT NULL,
    phone VARCHAR(15),
    semester INT NOT NULL,
    cgpa DECIMAL(3,2) NOT NULL
);

-- Sample records for testing (optional)
INSERT INTO students (name, email, department, phone, semester, cgpa)
VALUES
('Ananya Sharma', 'ananya@example.com', 'Computer Science', '9876543210', 5, 8.70),
('Rahul Kumar', 'rahul@example.com', 'Information Science', '9876501234', 5, 8.20),
('Priya Nair', 'priya@example.com', 'Computer Science', '9988776655', 5, 9.10);
