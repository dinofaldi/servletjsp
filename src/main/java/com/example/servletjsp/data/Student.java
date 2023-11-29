package com.example.servletjsp.data;

public class Student {
  
  private int id;
  private String name;
  private int marks;
  private Department department;

  public Student(int id, String name, int marks, Department department){
    this.id = id;
    this.name = name;
    this.marks = marks;
    this.department = department;
  }

  public int getId(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

  public int getMarks(){
    return this.marks;
  }

  public Department getDepartment(){
    return this.department;
  }

  public void setId(int id){
    this.id = id;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setDepartment(Department department){
    this.department = department;
  }

  public void setMarks(int marks){
    this.marks = marks;
  }

  public static Student[] createStudent() {
    Student[] students = new Student[8];
    students[0] = new Student(1, "Student 1", 35, Department.getDepartment(1));
    students[1] = new Student(2, "Student 2", 70, Department.getDepartment(1));
    students[2] = new Student(3, "Student 3", 60, Department.getDepartment(1));
    students[3] = new Student(4, "Student 4", 90, Department.getDepartment(1));
    students[4] = new Student(5, "Student 5", 30, Department.getDepartment(2));
    students[5] = new Student(6, "Student 6", 32, Department.getDepartment(3));
    students[6] = new Student(7, "Student 7", 70, Department.getDepartment(3));
    students[7] = new Student(8, "Student 8", 20, Department.getDepartment(3));
    return students;
  }
}
