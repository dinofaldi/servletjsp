package com.example.servletjsp.data;

public class Department {
  
  private int id;
  private String name;
  private double passMark;
  
  public Department(int id, String name, double passMark){
    this.id = id;
    this.name = name;
    this.passMark = passMark;
  }
  
  public int getId(){
    return this.id;
  }
  
  public String getName(){
    return this.name;
  }

  public double getPassMark() {
    return passMark;
  }
  
  public void setId(int id){
    this.id = id;
  }
  
  public void setName(String name){
    this.name = name;
  }

  public void setPassMark(double passMark) {
    this.passMark = passMark;
  }

  public static Department[] createDepartment() {
    Department[] departments = new Department[3];
    departments[0] = new Department(1, "Department 1", 0);
    departments[1] = new Department(2, "Department 2", 0);
    departments[2] = new Department(3, "Department 3", 0);
    return departments;
  }

  public static Department getDepartment(int id) {
    Department[] departments = Department.createDepartment();
    for (Department department : departments) {
      if (department.getId() == id) {
        return department;
      }
    }
    return null;
  }
}
