<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Management System - Login</title>
    <link rel="stylesheet" href="css/login.css"> <!-- External CSS -->
</head>
<body>
    <%@ include file="header.jsp" %>
    <main>
        <div class="login-container">
            <h2>Login to Your Account</h2>

            <!-- Display error message if present -->
            <c:if test="${not empty param.error}">
                <div class="error-message">
                    ${param.error}
                </div>
            </c:if>

            <form action="log" method="POST" class="login-form">
                <label for="uid">Username:</label>
                <input type="text" id="uid" name="uid" required><br>

                <label for="pass">Password:</label>
                <input type="password" id="pass" name="pass" required><br>

                <input type="submit" name="submit" value="Login" class="btn">
            </form>
        </div>
    </main>
</body>
</html>