package com.example.servletjsp;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{
  
  private static String username = "admin";
  private static String password = "admin";

  public static boolean check(String username, String password){
    return username.equals(Login.username) && password.equals(Login.password);
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
    dispatcher.forward(req, resp);
  }
  
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    if(Login.check(username, password)){
      // redirect to welcome page and set session
      req.getSession().setAttribute("username", username);
      resp.sendRedirect("welcome?username=" + username);
    }else{
      req.setAttribute("error", "Invalid username or password");
      RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
      dispatcher.forward(req, resp);
    }
  }
}
