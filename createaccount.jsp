<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Your Account</title>
    <link rel="stylesheet" href="css/create-account-style.css"> <!-- External CSS -->
</head>
<body>
    <jsp:include page="header.jsp" />
    <main>
        <div class="create-account-container">
            <h2>Create Your Account</h2>

            <!-- Display error message if account creation fails -->
            <c:if test="${not empty param.error}">
                <div class="error-message">
                    ${param.error}
                </div>
            </c:if>

            <!-- Display success message if account creation succeeds -->
            <c:if test="${not empty param.success}">
                <div class="success-message">
                    ${param.success}
                </div>
            </c:if>

            <form action="insert" method="POST" class="create-account-form">
                <label for="username">Username:</label>
                <input type="text" id="username" name="user" required><br>

                <label for="password">Password:</label>
                <input type="password" id="password" name="pass" required><br>

                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required><br>

                <label for="phone">Phone Number:</label>
                <input type="text" id="phone" name="phone_number" required><br>

                <label for="country">Country:</label>
                <input type="text" id="country" name="country" required><br>

                <label for="address">Address:</label>
                <input type="text" id="address" name="address" required><br>

                <label for="gender">Gender:</label>
                <input type="text" id="gender" name="gender" required><br>

                <input type="submit" name="submit" value="Create Account" class="btn">
            </form>
        </div>
    </main>
</body>
</html>