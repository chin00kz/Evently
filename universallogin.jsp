<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Portal</title>
    <!-- Bootstrap CDN for CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/login-portal.css"> <!-- External CSS -->
</head>
<body>
    <%@ include file="headerafterlog.jsp" %>
    <div class="container">
        <div class="row justify-content-center align-items-center vh-100">
            <div class="col-lg-4 col-md-6 col-sm-12 text-center">
                <div class="portal-section">
                    <h2>User Login</h2>
                    <p>Click here to log in as a user</p>
                    <a href="index.jsp" class="btn btn-primary btn-block">User Login</a>
                    <!-- Registration link below user login -->
                    <p class="mt-3">
                        Don't have an account? 
                        <a href="createaccount.jsp" class="register-link">Register as a User</a>
                    </p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-12 text-center">
                <div class="portal-section">
                    <h2>Admin Login</h2>
                    <p>Click here to log in as an admin.</p>
                    <a href="adlog.jsp" class="btn btn-danger btn-block">Admin Login</a>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 col-sm-12 text-center">
                <div class="portal-section">
                    <h2>Staff Login</h2>
                    <p>Click here to log in as a staff</p>
                    <a href="suplog.jsp" class="btn btn-success btn-block">Staff Login</a>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
