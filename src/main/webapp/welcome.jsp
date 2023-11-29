<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servletjsp.data.Department" %>
<%@ page import="com.example.servletjsp.data.Student" %>
<html>
  <head>
    <title>Welcome Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  </head>

  <body>
    <div class="container mt-3">
      <h2>Welcome, <%= request.getParameter("username") %>!</h2>
      <!-- loop and print department attribute to table-->
      <div class="table-responsive">
        <table class="table">
          <thead class="bg-info">
            <tr>
              <th scope="col">Department</th>
              <th scope="col">Student Id</th>
              <th scope="col">Marks</th>
              <th scope="col">Pass %</th>
            </tr>
          </thead>
          <tbody>
            <% 
              Department[] departments = (Department[]) request.getAttribute("departments");
              Student[][] studentsByDepartment = (Student[][]) request.getAttribute("studentsByDepartment");
              for (int i = 0; i < departments.length; i++) {
            %>
              <tr>
                <td rowspan="<%= studentsByDepartment[i].length %>"><%= departments[i].getName() %></td>
                <!-- pop up alert js show student name when click -->
                <td> <a href="#" onclick="alert('<%= studentsByDepartment[i][0].getName() %>')"><%= studentsByDepartment[i][0].getId() %></a></td>
                <td><%= studentsByDepartment[i][0].getMarks() %></td>
                <td rowspan="<%= studentsByDepartment[i].length %>"><%= departments[i].getPassMark() %></td>
              </tr>
              <% 
                for (int j = 1; j < studentsByDepartment[i].length; j++) {
              %>
                <tr>
                  <td> <a href="#" onclick="alert('<%= studentsByDepartment[i][j].getName() %>')"><%= studentsByDepartment[i][j].getId() %></a></td>
                  <td><%= studentsByDepartment[i][j].getMarks() %></td>
                </tr>
              <% 
                }
              %>
            <%
              }
            %>
          </tbody>
        </table>
      </div>
    </div>
  </body>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</html>