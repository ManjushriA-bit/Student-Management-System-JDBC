package com.manjushri.sms;

import java.util.List;
import java.util.Scanner;

/** Console application for managing student records. */
public class StudentManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("       STUDENT MANAGEMENT SYSTEM - JDBC");
        System.out.println("==============================================");

        while (true) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("\nThank you for using Student Management System!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please select 1-6.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n--------------- MENU ----------------");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.println("-------------------------------------");
    }

    private static void addStudent() {
        System.out.println("\n--- Add Student ---");
        Student student = readStudentDetails();
        if (dao.addStudent(student)) {
            System.out.println("Student added successfully!");
        }
    }

    private static void viewStudents() {
        System.out.println("\n--- All Students ---");
        List<Student> students = dao.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.printf("%-5s %-20s %-28s %-15s %-15s %-9s %-6s%n",
                "ID", "Name", "Email", "Department", "Phone", "Semester", "CGPA");
        System.out.println("------------------------------------------------------------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-5d %-20s %-28s %-15s %-15s %-9d %-6.2f%n",
                    s.getId(), s.getName(), s.getEmail(), s.getDepartment(),
                    s.getPhone(), s.getSemester(), s.getCgpa());
        }
    }

    private static void searchStudent() {
        System.out.println("\n--- Search Student ---");
        int id = readInt("Enter student ID: ");
        Student s = dao.getStudentById(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        printStudent(s);
    }

    private static void updateStudent() {
        System.out.println("\n--- Update Student ---");
        int id = readInt("Enter student ID to update: ");
        Student existing = dao.getStudentById(id);
        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Current details:");
        printStudent(existing);
        System.out.println("\nEnter new details:");
        Student updated = readStudentDetails();
        updated.setId(id);
        if (dao.updateStudent(updated)) {
            System.out.println("Student updated successfully!");
        }
    }

    private static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        int id = readInt("Enter student ID to delete: ");
        Student existing = dao.getStudentById(id);
        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Student: " + existing.getName() + " (ID: " + id + ")");
        System.out.print("Are you sure you want to delete this student? (yes/no): ");
        String confirmation = scanner.nextLine().trim();
        if (confirmation.equalsIgnoreCase("yes")) {
            if (dao.deleteStudent(id)) {
                System.out.println("Student deleted successfully!");
            }
        } else {
            System.out.println("Delete operation cancelled.");
        }
    }

    private static Student readStudentDetails() {
        String name = readNonEmpty("Name: ");
        String email = readNonEmpty("Email: ");
        String department = readNonEmpty("Department: ");
        String phone = readNonEmpty("Phone: ");
        int semester = readIntInRange("Semester (1-8): ", 1, 8);
        double cgpa = readDoubleInRange("CGPA (0-10): ", 0, 10);
        return new Student(name, email, department, phone, semester, cgpa);
    }

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("This field cannot be empty.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static int readIntInRange(String prompt, int min, int max) {
        while (true) {
            int value = readInt(prompt);
            if (value >= min && value <= max) return value;
            System.out.println("Please enter a value between " + min + " and " + max + ".");
        }
    }

    private static double readDoubleInRange(String prompt, double min, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value >= min && value <= max) return value;
                System.out.println("Please enter a value between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void printStudent(Student s) {
        System.out.println("\nStudent Details");
        System.out.println("---------------------------");
        System.out.println("ID         : " + s.getId());
        System.out.println("Name       : " + s.getName());
        System.out.println("Email      : " + s.getEmail());
        System.out.println("Department : " + s.getDepartment());
        System.out.println("Phone      : " + s.getPhone());
        System.out.println("Semester   : " + s.getSemester());
        System.out.printf("CGPA       : %.2f%n", s.getCgpa());
    }
}
