package com.example.servletjsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.servletjsp.data.Department;
import com.example.servletjsp.data.Student;

public class Welcome extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (
      req.getParameter("username") == null
      || req.getParameter("username").isEmpty()
      || !req.getParameter("username").equals("admin")
      || req.getSession().getAttribute("username") == null
      || !req.getSession().getAttribute("username").equals("admin")
    ) {
      resp.sendRedirect("login");
      return;
    }

    Department[] departments = Department.createDepartment();
    Student[] students = Student.createStudent();
    int minMarks = 40;

    Student[][] studentsByDepartment = new Student[departments.length][];
    for (int i = 0; i < departments.length; i++) {
      int count = 0;
      int passCount = 0;
      for (Student student : students) {
        if (student.getDepartment().getId() == departments[i].getId()) {
          count++;
          if (student.getMarks() >= minMarks) {
            passCount++;
          }
        }
      }
      studentsByDepartment[i] = new Student[count];

      departments[i].setPassMark((double) passCount / count * 100);
    }
    
    for (int i = 0; i < departments.length; i++) {
      int j = 0;
      for (Student student : students) {
        if (student.getDepartment().getId() == departments[i].getId()) {
          studentsByDepartment[i][j] = student;
          j++;
        }
      }
    }

    req.setAttribute("departments", departments);
    req.setAttribute("studentsByDepartment", studentsByDepartment);

    RequestDispatcher dispatcher = req.getRequestDispatcher("welcome.jsp");
    dispatcher.forward(req, resp);
  }
}
