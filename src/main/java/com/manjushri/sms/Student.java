package com.manjushri.sms;

/** Model class representing one student. */
public class Student {
    private int id;
    private String name;
    private String email;
    private String department;
    private String phone;
    private int semester;
    private double cgpa;

    public Student() { }

    public Student(String name, String email, String department, String phone, int semester, double cgpa) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.phone = phone;
        this.semester = semester;
        this.cgpa = cgpa;
    }

    public Student(int id, String name, String email, String department, String phone, int semester, double cgpa) {
        this(name, email, department, phone, semester, cgpa);
        this.id = id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }
    public double getCgpa() { return cgpa; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }
}
