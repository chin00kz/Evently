<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Supplier</title>
    <link rel="stylesheet" href="css/create-account-style.css"> <!-- External CSS -->
</head>
<body>
    <jsp:include page="header.jsp" />
     <%@ include file="topheader.jsp" %> 
    <main>
        <div class="create-account-container">
            <h2>Create Supplier Account</h2>

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

            <form action="supadd" method="POST" class="create-account-form">
                
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required><br>
                
                <label for="email">Email:</label>
                <input type="text" id="email" name="email" required><br>
                
                <label for="username">Username:</label>
                <input type="text" id="username" name="user" required><br>

                <label for="password">Password:</label>
                <input type="password" id="password" name="pass" required><br>                               
              
                <input type="submit" name="submit" value="Add Account" class="btn">
            </form>
        </div>
    </main>
</body>
</html>