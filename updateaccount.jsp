<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Customer Details</title>
    <link rel="stylesheet" href="css/update-style.css"> <!-- Optional for styling -->
</head>
<body>

    <%
            String id = request.getParameter("id");
    		String name = request.getParameter("name");
            String username = request.getParameter("username");
    		String phone_number = request.getParameter("phone_number");
    		String country = request.getParameter("country");
    		String address = request.getParameter("address");
    		String gender = request.getParameter("gender");
    		String password = request.getParameter("password");
    %>
    
    <div class="update-container">
        <h2>Update Your Account Information</h2>

        <form action="update" method="POST">
            <input type="hidden" name="id" value="<%=id%>">

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="<%=username%>" readyonly><br>

            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="<%=name%>" required><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="<%=password%>" required><br>

            <label for="phone">Phone Number:</label>
            <input type="text" id="phone" name="phone_number" value="<%=phone_number%>" required><br>

            <label for="country">Country:</label>
            <input type="text" id="country" name="country" value="<%=country%>" required><br>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" value="<%=address%>" required><br>

            <input type="submit" name="submit" value="Update Details" class="btn">
        </form>
    </div>
</body>
</html>
