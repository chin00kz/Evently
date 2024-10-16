<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Supplier Login</title>
    <link rel="stylesheet" href="css/suplog.css"> <!-- External CSS for styling -->
</head>
<body>
<jsp:include page="header.jsp" />
    <h2>Supplier Login</h2>
   <form action="suplog" method="POST"> 
    <label for="supplierpass">Username:</label>
    <input type="text" id="suname" name="suname" required><br> <!-- Ensure the name matches the servlet -->
    <label for="supplierpass">Password:</label>
    <input type="password" id="pass" name="pass" required><br>
    <input type="submit" value="Login" name="submit">
</form>

</body>
</html>
