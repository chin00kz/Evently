<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <link rel="stylesheet" href="css/login-style.css">
</head>
<body>
    <jsp:include page="header.jsp" />
    <main class="main-content">
        <div class="adm-login-container">
            <h2 class="adm-heading">Admin Login</h2>
            <form action="adlog" method="POST" class="adm-login-form">
                <div class="form-group">
                    <label for="auname" class="adm-label">Username:</label>
                    <input type="text" id="auname" name="auname" class="adm-input" required>
                </div>
                <div class="form-group">
                    <label for="pass" class="adm-label">Password:</label>
                    <input type="password" id="pass" name="pass" class="adm-input" required>
                </div>
                <input type="submit" value="Login" name="submit" class="adm-btn">
            </form>
        </div>
    </main>
</body>
</html>