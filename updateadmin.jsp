<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Admin Details</title>
    <link rel="stylesheet" href="css/update-style.css">
</head>
<body>

  <%
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Debugging output
    System.out.println("id: " + id);
    System.out.println("name: " + name);
    System.out.println("username: " + username);
    System.out.println("password: " + password);
%>

    
    <div class="update-container">
        <h2>Update Your Account Information</h2>

        <form action="updateadmin" method="POST">
            <input type="hidden" name="id" value="<%=id%>">
            
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="<%=name%>" required><br>

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="<%=username%>" readonly><br>
            
           
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="<%=password%>" required><br>

           
            <input type="submit" name="submit" value="Update Details" class="btn">
        </form>
    </div>
</body>
</html>
